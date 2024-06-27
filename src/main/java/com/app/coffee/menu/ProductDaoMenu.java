package com.app.coffee.menu;

import com.app.coffee.Backend.Connect.ConnectionCoffee;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;

import com.app.coffee.product.DatabaseConnection;

public class ProductDaoMenu {
    private Component parentComponent;

    public List<ProductMenu> getAllProducts() {
        List<ProductMenu> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE status = 1";

        try (Connection con = DatabaseConnection.getJDBConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int categoryId = rs.getInt("category_id");
                String productName = rs.getString("product_name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                String size = rs.getString("size");
                int status = rs.getInt("status");

                ProductMenu product = new ProductMenu(productId, productName, price, categoryId, description, size, status);
                products.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error!! " + e.getMessage());
        }
        return products;
    }

    
    public List<ProductMenu> getLengthProductsByCategoryId(int categoryId) {
        List<ProductMenu> products = new ArrayList<>();
        String sql;
        if (categoryId == 0) {
            sql = "SELECT * FROM product WHERE status = 1";
        } else {
            sql = "SELECT * FROM product WHERE category_id = ? AND status = 1";
        }

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            if (categoryId != 0) {
                pstmt.setInt(1, categoryId);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                // Traverse through records and add them to the list
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    int categoryIdFromDb = rs.getInt("category_id");
                    String productName = rs.getString("product_name");
                    float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    String size = rs.getString("size");
                    int status = rs.getInt("status");

                    ProductMenu product = new ProductMenu(productId, productName, price, categoryIdFromDb, description, size, status);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error!! " + e.getMessage());
        }
        return products;
    }

    
    public ProductMenu selectProduct(int status){
                
        String sql = "SELECT * FROM product WHERE category_id = ? AND status = 1";
        try (Connection conn = ConnectionCoffee.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, status);
            
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    ProductMenu productMenu = new ProductMenu();

                    productMenu.setPrice(rs.getInt("price"));
                    productMenu.setProduct_name(rs.getString("cateogry_name"));
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    // Example of usage in main method (you can remove or comment this out in production code)
    public static void main(String[] args) {
        ProductDaoMenu dao = new ProductDaoMenu();

        // Fetch all products
        List<ProductMenu> products = dao.getAllProducts();
        for (ProductMenu product : products) {
            System.out.println(product);
        }
        
    }
}
