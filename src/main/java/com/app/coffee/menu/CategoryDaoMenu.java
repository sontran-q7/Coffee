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
    
//    public static void main(String[] args) {
//        CategoryDaoMenu dao = new CategoryDaoMenu();
//        List<CategoryMenu> categories = dao.getAllCategories();
//        for (CategoryMenu category : categories) {
//            System.out.println(category);
//            System.out.println("aaaaaaa");
//        }
//    
//    }
    
//    public List<OrderDetailProduct> getOrderDetailsForOrder(int orderId) {
//        List<OrderDetailProduct> orderDetails = new ArrayList<>();
//        String sql = "SELECT o.order_id, " +
//                     "od.quantity, " +
//                     "od.total, " +
//                     "od.description, " +
//                     "p.product_id, " +
//                     "p.product_name, " +
//                     "p.price, " +
//                     "p.description AS product_description, " +
//                     "p.size " +
//                     "FROM `order` o " +
//                     "JOIN order_detail od ON o.order_detail_id = od.order_detail_id " +
//                     "JOIN product p ON o.product_id = p.product_id " +
//                     "WHERE o.order_id = ?";
//
//        try (Connection con = DatabaseConnection.getJDBConnection();
//             PreparedStatement pstmt = con.prepareStatement(sql)) {
//            pstmt.setInt(1, orderId);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    int ordId = rs.getInt("order_id");
//                    int quantity = rs.getInt("quantity");
//                    double total = rs.getDouble("total");
//                    String orderDescription = rs.getString("description");
//                    int prodId = rs.getInt("product_id");
//                    String productName = rs.getString("product_name");
//                    double price = rs.getDouble("price");
//                    String productDescription = rs.getString("product_description");
//                    String size = rs.getString("size");
//
//                    OrderDetailProduct odp = new OrderDetailProduct(ordId, quantity, total, orderDescription, prodId, productName, price, productDescription, size);
//                    orderDetails.add(odp);
//                }
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(parentComponent, "Error!! " + e.getMessage());
//        }
//        return orderDetails;
//    }
//
//    public static void main(String[] args) {
//        CategoryDaoMenu dao = new CategoryDaoMenu();
//        List<OrderDetailProduct> orderDetails = dao.getOrderDetailsForOrder(1);
//        for (OrderDetailProduct orderDetail : orderDetails) {
//            System.out.println(orderDetail);
//        }
//    }
}
