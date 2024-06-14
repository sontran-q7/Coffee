/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.coffee.product.DatabaseConnection; // Import lớp Connection từ gói com.app.coffee.product
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Acer
 */
public class CategoryDao {

    private Component parentComponent;
    
    // add category
    public void insertCat(String ID, String category, String description) {
        if (isIdExists(ID)) {
            JOptionPane.showMessageDialog(parentComponent, "ID đã tồn tại trong cơ sở dữ liệu.");
            return; // Kết thúc phương thức nếu ID đã tồn tại
        }
        // Chuẩn bị câu lệnh SQL để chèn dữ liệu vào bảng category
        String sql = "INSERT INTO category (ID, category, description) VALUES (?, ?, ?)";
        // Sử dụng try-with-resources để tự động đóng kết nối sau khi sử dụng xong
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            // Thiết lập giá trị cho các tham số của câu lệnh SQL
            pstmt.setString(1, ID);
            pstmt.setString(2, category);
            pstmt.setString(3, description);
            // Thực thi câu lệnh SQL để chèn dữ liệu
            pstmt.executeUpdate();
//            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            // In ra thông báo nếu thành công
            JOptionPane.showMessageDialog(parentComponent, "Thêm thành công");
            //cập nhật lại bảng TableCate
            ProductForm productForm = new ProductForm();
            productForm.updateCategoryTable();
        } catch (SQLException e) {
            // Xử lý các lỗi SQL
            e.printStackTrace();
        }
    }
    
    // Phương thức này trả về một danh sách các đối tượng Category từ cơ sở dữ liệu
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            // Duyệt qua các bản ghi và thêm chúng vào danh sách
            while (rs.next()) {
                String id = rs.getString("ID");
                String category = rs.getString("category");
                String description = rs.getString("description");
                Category c = new Category(id, category, description);
                categories.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
    //kiem tra id
    public boolean isIdExists(String id) {
        String sql = "SELECT COUNT(*) FROM category WHERE ID = ?";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Trả về true nếu ID đã tồn tại
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // edit category
    public boolean updateCategory(String ID, String newCategory, String newDescription) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean success = false;

        try {
            con = DatabaseConnection.getJDBConnection();
            String query = "UPDATE category SET category = ?, description = ? WHERE id = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, newCategory);
            stmt.setString(2, newDescription);
            stmt.setString(3, ID);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error updating category: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
            }
        }

        return success;
    }
    // delete category
    public boolean deleteCategory(String categoryID) {
        try {
            Connection con = DatabaseConnection.getJDBConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM category WHERE ID = ?");
            ps.setString(1, categoryID);
            int rowsDeleted = ps.executeUpdate();
            con.close();
            if (rowsDeleted > 0) {
                return true;
            } else {
                // Xử lý trường hợp không có hàng nào được xóa
                System.out.println("Không có dữ liệu nào được xóa.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
