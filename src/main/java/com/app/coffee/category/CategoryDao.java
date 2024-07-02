/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.category;

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
//    private Connection con; // Đối tượng kết nối cơ sở dữ liệu

    private Component parentComponent;
    private CategoryForm categoryForm;

    // add category
    public void insertCat(String category_name, String description) {
        String sql = "INSERT INTO category (category_name, description, status) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, category_name);
            pstmt.setString(2, description);
            pstmt.setString(3, "1"); //status mac dinh la 1 khi them moi

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm mới danh mục thành công!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding category: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Phương thức này trả về một danh sách các đối tượng Category từ cơ sở dữ liệu
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category WHERE status = 1";
        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int category_id = rs.getInt("category_id");
                String category_name = rs.getString("category_name");
                String description = rs.getString("description");
                String status = rs.getString("status");

                Category c = new Category(category_id, category_name, description, status);
                categories.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving categories: " + e.getMessage());
            e.printStackTrace();
        }
        return categories;
    }

    //kiem tra category
    public boolean isCategoryExists(String category_name) {
        String sql = "SELECT COUNT(*) FROM category WHERE category_name = ?";
        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, category_name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Trả về true nếu category_name đã tồn tại
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isCategoryIdExists(int category_id) {
        String sql = "SELECT COUNT(*) FROM category WHERE category_id = ?";
        try (Connection con = DatabaseConnection.getJDBConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, category_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Trả về true nếu categoryId đã tồn tại
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // edit category
    public boolean updateCategory(Category category) {
        String sql = "UPDATE category SET category_name = ?, description = ? WHERE category_id = ?";

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, category.getCategory_name());
            pstmt.setString(2, category.getDescription());
            pstmt.setInt(3, category.getCategory_id());
            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating category: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // delete category
    public boolean deleteCategory(String category_id) {
        String sql = "UPDATE category SET status = 2 WHERE category_id = ?";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, category_id);

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
}
