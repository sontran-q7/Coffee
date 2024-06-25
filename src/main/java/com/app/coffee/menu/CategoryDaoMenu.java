/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.menu;

import com.app.coffee.product.ProductForm;
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
 * @author admin
 */
public class CategoryDaoMenu {
    private Component parentComponent;
    
    public List<CategoryMenu> getAllCategories() {
        List<CategoryMenu> categories = new ArrayList<>();
//          String sql = "SELECT * FROM category";
            String sql = "SELECT * FROM category WHERE status = 1";
            
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            // Duyệt qua các bản ghi và thêm chúng vào danh sách
            while (rs.next()) {
                
                int category_id = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                
                System.out.println("category_id: " + category_id);
                System.out.println("categoryName: " + categoryName);
                System.out.println("description: " + description);
                
                CategoryMenu c = new CategoryMenu(category_id, categoryName, description, status);
                categories.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error!! " + e.getMessage() );
        }
        return categories;
    }
    
    public static void main(String[] args) {
        CategoryDaoMenu dao = new CategoryDaoMenu();
        List<CategoryMenu> categories = dao.getAllCategories();
        for (CategoryMenu category : categories) {
            System.out.println(category);
            System.out.println("aaaaaaa");
        }
    
    }
}
