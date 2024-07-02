/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.coffee.product.DatabaseConnection; 
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class CategoryDaoMenu {
    private Component parentComponent;
    
    public List<CategoryMenu> getAllCategories() {
        List<CategoryMenu> categories = new ArrayList<>();
            String sql = "SELECT * FROM category WHERE status = 1";
            
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                
                int category_id = rs.getInt("category_id");
                String categoryName = rs.getString("category_name");
                String description = rs.getString("description");
                int status = rs.getInt("status");
                                
                CategoryMenu c = new CategoryMenu(category_id, categoryName, description, status);
                categories.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error!! " + e.getMessage() );
        }
        return categories;
    }
    
}
