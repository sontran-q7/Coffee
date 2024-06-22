/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.category;

import com.app.coffee.category.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.coffee.product.DatabaseConnection; // Import lớp Connection từ gói com.app.coffee.product
import com.app.coffee.product.DatabaseConnection;

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
        try {
            // Kiểm tra xem ID đã tồn tại và có status là 2 hay không
            String checkSql = "SELECT status FROM category WHERE ID = ?";
            try (Connection con = DatabaseConnection.getJDBConnection();
                 PreparedStatement checkStmt = con.prepareStatement(checkSql)) {

                checkStmt.setString(1, ID);
                
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        int status = rs.getInt("status");
                        if (status == 2) {
                            // Nếu ID đã tồn tại và có status là 2, tái sử dụng lại bằng cách cập nhật status về 1
                            reactivateCategory(ID);
                            // Sau khi tái sử dụng lại, tiếp tục thêm mới Category với status là 1
//                            insertNewCategory(con, ID, category, description);
                        } else {
                            // Nếu ID đã tồn tại nhưng có status khác 2, thông báo lỗi
                            JOptionPane.showMessageDialog(parentComponent, "ID đã tồn tại trong cơ sở dữ liệu.");
                        }
                    } else {
                        // Nếu ID chưa tồn tại, thêm mới Category với status là 1
                        insertNewCategory(con, ID, category, description);
                    }
                }
            }
            // Sau khi tái sử dụng lại hoặc khi ID đã tồn tại với status = 1, cho phép chỉnh sửa category và description
        updateReturnCategory(ID, category, description);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Lỗi khi thêm sản phẩm");
            e.printStackTrace();
        }
    }
    
    // Phương thức này trả về một danh sách các đối tượng Category từ cơ sở dữ liệu
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
//          String sql = "SELECT * FROM category";
            String sql = "SELECT * FROM category WHERE status = 1";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            // Duyệt qua các bản ghi và thêm chúng vào danh sách
            while (rs.next()) {
                String id = rs.getString("ID");
                String category = rs.getString("category");
                String description = rs.getString("description");
                String status = rs.getString("status");
                Category c = new Category(id, category, description, status);
                categories.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error!! " + e.getMessage());
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
        
        String sql = "UPDATE category SET status = 1 WHERE ID = ? AND status = 2"; // Chỉ cập nhật nếu status là 2

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
        String sql = "UPDATE category SET status = 2 WHERE ID = ?";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, categoryID);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Lỗi khi xóa sản phẩm");
            e.printStackTrace();
        }
        return false;
    }
    
    public void reactivateCategory(String ID) throws SQLException {
        String sql = "UPDATE category SET status = 1 WHERE ID = ?";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, ID);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(parentComponent, "Đã tái sử dụng lại sản phẩm thành công");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Lỗi khi tái sử dụng sản phẩm");
            throw e; // Ném lại lỗi để báo lỗi khi cần thiết
        }
    }

    private void insertNewCategory(Connection con, String ID, String category, String description) throws SQLException {
        String sql = "INSERT INTO category (ID, category, description, status) VALUES (?, ?, ?, 1)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, ID);
            pstmt.setString(2, category);
            pstmt.setString(3, description);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(parentComponent, "Thêm mới sản phẩm thành công");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Lỗi khi thêm sản phẩm");
            throw e; // Ném lại lỗi để báo lỗi khi cần thiết
        }
    }

    private void updateReturnCategory(String ID, String newCategory, String newDescription) {
            try (Connection con = DatabaseConnection.getJDBConnection()) {
            String sql = "UPDATE category SET category = ?, description = ?, status = 1 WHERE ID = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, newCategory);
                pstmt.setString(2, newDescription);
                pstmt.setString(3, ID);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(parentComponent, "Cập nhật sản phẩm thành công");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(parentComponent, "Lỗi khi cập nhật sản phẩm");
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(parentComponent, "Lỗi kết nối cơ sở dữ liệu");
            ex.printStackTrace();
        }
    }
}
