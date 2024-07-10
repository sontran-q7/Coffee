package com.app.coffee.menu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;

import com.app.coffee.product.DatabaseConnection;
import java.sql.Statement;

public class ProductDaoMenu {
    private Component parentComponent;

    public List<ProductMenu> getAllProducts() {
        List<ProductMenu> products = new ArrayList<>();
        String sql = "SELECT p.product_id, p.category_id, p.product_name, " +
                     "pdS.price AS priceS, pdL.price AS priceL, " +
                     "p.description, p.image, p.status " + // Thêm trường image vào câu truy vấn
                     "FROM product p " +
                     "JOIN product_detail pdS ON p.product_id = pdS.product_id AND pdS.size = 'S' " +
                     "JOIN product_detail pdL ON p.product_id = pdL.product_id AND pdL.size = 'L' " +
                     "WHERE p.status = 1 AND pdS.status = 1 AND pdL.status = 1";

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int categoryId = rs.getInt("category_id");
                String productName = rs.getString("product_name");
                float priceS = rs.getFloat("priceS");
                float priceL = rs.getFloat("priceL");
                String description = rs.getString("description");
                String image = rs.getString("image"); // Lấy thông tin ảnh từ cột image
                int status = rs.getInt("status");

                ProductMenu product = new ProductMenu(productId, productName, priceS, priceL, categoryId, description, sql, image, status);
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
            sql = "SELECT p.product_id, p.category_id, p.product_name, " +
                  "pdS.price AS priceS, pdL.price AS priceL, " +
                  "p.description, p.image, p.status " +
                  "FROM product p " +
                  "JOIN product_detail pdS ON p.product_id = pdS.product_id AND pdS.size = 'S' " +
                  "JOIN product_detail pdL ON p.product_id = pdL.product_id AND pdL.size = 'L' " +
                  "WHERE p.status = 1 AND pdS.status = 1 AND pdL.status = 1";
        } else {
            sql = "SELECT p.product_id, p.category_id, p.product_name, " +
                  "pdS.price AS priceS, pdL.price AS priceL, " +
                  "p.description, p.image, p.status " +
                  "FROM product p " +
                  "JOIN product_detail pdS ON p.product_id = pdS.product_id AND pdS.size = 'S' " +
                  "JOIN product_detail pdL ON p.product_id = pdL.product_id AND pdL.size = 'L' " +
                  "WHERE p.category_id = ? AND p.status = 1 AND pdS.status = 1 AND pdL.status = 1";
        }

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            if (categoryId != 0) {
                pstmt.setInt(1, categoryId);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    int categoryIdFromDb = rs.getInt("category_id");
                    String productName = rs.getString("product_name");
                    float priceS = rs.getFloat("priceS");
                    float priceL = rs.getFloat("priceL");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    String image = rs.getString("image");

                    ProductMenu product = new ProductMenu(productId, productName, priceS, priceL, categoryIdFromDb, description, "", status, null, image);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error!! " + e.getMessage());
        }
        return products;
    }


    public Integer insertOrderDetail(int orderId, String productName, String size, int quantity, String sugar, float price) {
        Integer orderDetailId = null;

        String getProductDetailIdSql = "SELECT pd.product_detail_id " +
                                       "FROM product_detail pd " +
                                       "JOIN product p ON pd.product_id = p.product_id " +
                                       "WHERE p.product_name = ? AND pd.size = ?";

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmtGetProductDetailId = con.prepareStatement(getProductDetailIdSql)) {

            pstmtGetProductDetailId.setString(1, productName);
            pstmtGetProductDetailId.setString(2, size);

            ResultSet rsProductDetailId = pstmtGetProductDetailId.executeQuery();

            if (rsProductDetailId.next()) {
                int productDetailId = rsProductDetailId.getInt("product_detail_id");

                // 2. Thêm dữ liệu vào bảng order_detail
                String insertOrderDetailSql = "INSERT INTO `order_detail` (`order_id`, `product_detail_id`, `quantity`, `status`, `created_at`, `updated_at`) "
                                            + "VALUES (?, ?, ?, ?, 'pending', NOW(), NOW())";

                try (PreparedStatement pstmtInsertOrderDetail = con.prepareStatement(insertOrderDetailSql, Statement.RETURN_GENERATED_KEYS)) {

                    pstmtInsertOrderDetail.setInt(1, orderId);
                    pstmtInsertOrderDetail.setInt(2, productDetailId);
                    pstmtInsertOrderDetail.setInt(3, quantity);

                    int rowsInserted = pstmtInsertOrderDetail.executeUpdate();

                    if (rowsInserted > 0) {
                        ResultSet generatedKeys = pstmtInsertOrderDetail.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            orderDetailId = generatedKeys.getInt(1); // Lấy order_detail_id từ generatedKeys
                        } else {
                            throw new SQLException("Failed to retrieve generated order_detail_id.");
                        }
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                throw new SQLException("Product detail not found for productName: " + productName + " and size: " + size);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetailId;
    }

    public int getProductIdByName(String productName) {
        int productId = -1; 

        String sql = "SELECT product_id FROM product WHERE product_name = ? AND status = 1";

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, productName);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    productId = rs.getInt("product_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productId;
    }
}