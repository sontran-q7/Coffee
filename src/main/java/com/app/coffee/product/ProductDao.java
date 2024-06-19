/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import com.app.coffee.product.DatabaseConnection; // Import lớp Connection từ gói com.app.coffee.product
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class ProductDao {
    private Component parentComponent;
    private ProductForm productForm;

    //add product   
    public void insertProd(String ID, String image, String category, String product, String size, String price) {
        if (isIdExists(ID)) {
            JOptionPane.showMessageDialog(parentComponent, "ID đã tồn tại trong cơ sở dữ liệu.");
            return;
        }
        
        String sql = "INSERT INTO product (ID, image, category, product, size, price) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = DatabaseConnection.getJDBConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            pstmt.setString(2, image);
            pstmt.setString(3, category);
            pstmt.setString(4, product);
            pstmt.setString(5, size);
            pstmt.setString(6, price);
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Thêm thành công");
            //cập nhật lại bảng TableCate
            ProductForm productForm = new ProductForm();
            productForm.updateProductTable();
            
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(parentComponent, "Lỗi khi thêm sản phẩm");
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("ID");
                String image = rs.getString("image");
                String category = rs.getString("category");
                String product = rs.getString("product");
                String size = rs.getString("size");
                String price = rs.getString("price");

                Product p = new Product(id, image, category, product, size, price);
                products.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error while fetching products: " + e.getMessage());
        e.printStackTrace();  // This will print detailed error trace to the console
        }
        return products;
    }
    

    private List<String> getCategoryNamesFromDatabase() {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT category_name FROM productTable";

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String categoryName = rs.getString("category_name");
                categories.add(categoryName);
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(parentComponent, "error");
            e.printStackTrace();
        }
        return categories;
    }
    
    
    
    public boolean updateProduct(String ID, String newImage, String newCategory, String newProduct, String newSize, String newPrice) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            con = DatabaseConnection.getJDBConnection();
            String query = "UPDATE product SET image = ?, category = ?, product = ?, size = ?, price = ? WHERE id = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, newImage);
            stmt.setString(2, newCategory);
            stmt.setString(3, newProduct);
            stmt.setString(4, newSize);
            stmt.setString(5, newPrice);
            stmt.setString(6, ID);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error updating product: " + ex.getMessage());
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

    public boolean deleteProduct(String productID) {
        try {
            Connection con = DatabaseConnection.getJDBConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE ID = ?");
            ps.setString(1, productID);
            int rowsDeleted = ps.executeUpdate();
            con.close();
            if (rowsDeleted > 0) {
                return true;
            } else {
                System.out.println("Không có dữ liệu nào được xóa.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //kiem tra id
    public boolean isIdExists(String id) {
        String sql = "SELECT COUNT(*) FROM product WHERE ID = ?";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, id);
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
    
    private List<Category> deserializeCategories(String categoriesString) {
        List<Category> categories = new ArrayList<>();
        String[] categoryArray = categoriesString.split(", ");
        for (String category : categoryArray) {
//            categories.add(new Category(category, "")); // Điền thông tin mô tả cho từng danh mục
        }
        return categories;
    }
    
    // Phương thức để lấy danh sách các category từ cơ sở dữ liệu
    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT id FROM category"; // Thay đổi query theo cấu trúc của bạn

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String category = rs.getString("id");
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return categories;
    }

    boolean hasProductsForCategory(String ID) {
        String sql = "SELECT COUNT(*) AS count FROM product WHERE id = ?";
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, ID);
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

    boolean deleteProductsForCategory(String ID) {
        String sql = "DELETE FROM product WHERE id = ?";
        
        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}