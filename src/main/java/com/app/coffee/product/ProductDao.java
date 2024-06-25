/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

import com.app.coffee.category.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.Component;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

import com.app.coffee.product.DatabaseConnection; // Import lớp Connection từ gói com.app.coffee.product
import java.io.File;
import javax.swing.table.DefaultTableModel;

public class ProductDao {

    private Component parentComponent;
    private ProductForm productForm;

    // add product
    public void insertProd(String image, int category_id, String product_name, String description, String size, int price) {
        String query = "INSERT INTO product (image, category_id, product_name, description, size, price, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, image);
            pstmt.setInt(2, category_id);
            pstmt.setString(3, product_name);
            pstmt.setString(4, description);
            pstmt.setString(5, size);
            pstmt.setInt(6, price);
            pstmt.setString(7, "1");

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Phương thức này trả về một danh sách các đối tượng Product từ cơ sở dữ liệu
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE status = 1";

        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String image = rs.getString("image");
                int category_id = rs.getInt("category_id");
                String product_name = rs.getString("product_name");
                String description = rs.getString("description");
                String size = rs.getString("size");
                int price = rs.getInt("price");
                String status = rs.getString("status");

                Product p = new Product(product_id, image, category_id, product_name, description, size, price, status);
                products.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error retrieving products");
            e.printStackTrace();
        }
        return products;
    }

    public   List<Category> getCategory() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category "; // Thay đổi query theo cấu trúc của bạn

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
            e.printStackTrace();
        }

        return categories;
    }

    List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT category_name FROM category ORDER BY category_name"; // Thay đổi query theo cấu trúc của bạn

        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String category = rs.getString("category_name");
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    public boolean isProductNameExists(String productName, String size, String price) {
        String query = "SELECT COUNT(*) FROM product WHERE product_name = ? AND size = ? AND price = ?";
        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, productName);
            pstmt.setString(2, size);
            pstmt.setString(3, price);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    List<String> getCategoryIdByName(String categoryName) {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT category_name FROM category ORDER BY category_name"; // Thay đổi query theo cấu trúc của bạn

        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String category = rs.getString("category_name");
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    public void updateProduct(Product p) throws SQLException {
        System.out.println(p.toString());
        // Thay đổi query theo cấu trúc của bạn
        String query = "UPDATE product SET product_name = ?,category_id=?, description = ?, price = ?,size=?, image=?   where product_id ="
                + p.getProduct_id();

        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, p.getProduct_name());
            pstmt.setInt(2, p.getCategory_id());
            pstmt.setString(3, p.getDescription());
            pstmt.setInt(4, p.getPrice());
             pstmt.setString(5, p.getSize());
            pstmt.setString(6, p.getImage());
          

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean deleteProduct(int product_id) {
        String sql = "DELETE FROM product WHERE product_id = ?";
    
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, product_id);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hasProductsForCategory(String category_id) {
        String sql = "SELECT COUNT(*) AS count FROM product WHERE category_id = ?";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, category_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProductsForCategory(String category_id) {
        String sql = "DELETE FROM product WHERE product_id = ?";
        
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, category_id);
            
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
