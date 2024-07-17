/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.DAO;

/**
 *
 * @author anhso
 */
import com.app.coffee.Backend.Connect.ConnectionCoffee;
import com.app.coffee.Backend.Model.OrderDetailModel;
import com.app.coffee.Backend.Model.OrderModel;
import com.app.coffee.Backend.Model.PendingBill;
import com.app.coffee.Backend.Model.ProductDetailModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BillDAO {

    public static List<PendingBill> getPendingBills() {
    List<PendingBill> pendingBills = new ArrayList<>();
    Connection conn = ConnectionCoffee.getConnection();
    String query = "SELECT o.order_id, o.total, GROUP_CONCAT(o.description SEPARATOR ', ') as description, " +
                   "o.day, o.created_at AS order_created_at, o.updated_at AS order_updated_at, " +
                   "GROUP_CONCAT(od.product_detail_id) AS product_details, SUM(od.quantity) AS total_quantity, " +
                   "od.table_number, od.status, od.created_at AS order_detail_created_at, od.updated_at AS order_detail_updated_at " +
                   "FROM orders o " +
                   "JOIN order_detail od ON o.order_id = od.order_id " +
                   "WHERE od.status = 1 " +
                   "GROUP BY o.order_id, od.table_number";
    try {
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            PendingBill bill = new PendingBill();
            bill.setOrder_id(rs.getInt("order_id"));
            bill.setTotal(rs.getFloat("total"));      
            bill.setTable_number(rs.getInt("table_number"));
            bill.setDescription(rs.getString("description"));
            bill.setDay(rs.getDate("day"));
            bill.setStatus(false); // Set status to false by default
            pendingBills.add(bill);
        }

        rs.close();
        stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        ConnectionCoffee.closeConnection(conn);
    }

    return pendingBills;
}

    
      // Phương thức để tính tổng total từ các đơn hàng trong tháng hiện tại
    public static float getTotalSumOfMonth() {
        float totalSum = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionCoffee.getConnection();
            String query = "SELECT SUM(total) AS total_sum " +
                           "FROM orders " +
                           "WHERE YEAR(day) = YEAR(CURDATE()) AND MONTH(day) = MONTH(CURDATE())";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            if (rs.next()) {
                totalSum = rs.getFloat("total_sum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ConnectionCoffee.closeConnection(conn);
        }

        return totalSum;
    }
    
    public static float getTotalSumOfDay() {
    float totalSum = 0;
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conn = ConnectionCoffee.getConnection();
        String query = "SELECT SUM(total) AS total_sum " +
                       "FROM orders " +
                       "WHERE DATE(day) = (CURDATE())";
        stmt = conn.prepareStatement(query);
       
        rs = stmt.executeQuery();

        if (rs.next()) {
            totalSum = rs.getFloat("total_sum");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ConnectionCoffee.closeConnection(conn);
    }

    return totalSum;
}

     public static void markBillAsFinished(int orderId) {
        String sql = "UPDATE order_detail SET status = 0 WHERE order_id = ?";
        try (Connection conn = ConnectionCoffee.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static OrderModel getOrderById(int orderId) {
        
        OrderModel orderModel = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionCoffee.getConnection();
            String query = "SELECT o.order_id, o.total, o.description, o.day, " +
                           "a.username AS account_username, a.email AS account_email, " +
                           "od.order_detail_id, od.product_detail_id, od.quantity, od.table_number, od.status AS order_detail_status, " +
                           "pd.size, pd.price, p.product_name " +
                           "FROM orders o " +
                           "LEFT JOIN account a ON o.account_id = a.account_id " +
                           "LEFT JOIN order_detail od ON o.order_id = od.order_id " +
                           "LEFT JOIN product_detail pd ON od.product_detail_id = pd.product_detail_id " +
                           "LEFT JOIN product p ON pd.product_id = p.product_id " +
                           "WHERE o.order_id = ? AND od.status = 1"; // Thêm điều kiện WHERE cho status

            stmt = conn.prepareStatement(query);
            stmt.setInt(1, orderId);
            rs = stmt.executeQuery();

            Map<Integer, OrderDetailModel> orderDetailsMap = new HashMap<>();

            while (rs.next()) {
                if (orderModel == null) {
                    orderModel = new OrderModel();
                    orderModel.setOrder_id(rs.getInt("order_id"));
                    orderModel.setTotal(rs.getFloat("total"));
                    orderModel.setDescription(rs.getString("description"));
                    orderModel.setDay(rs.getDate("day").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                    orderModel.setUsername(rs.getString("account_username"));
                    orderModel.setEmail(rs.getString("account_email"));
                }

                int orderDetailId = rs.getInt("order_detail_id");
                OrderDetailModel orderDetail = orderDetailsMap.get(orderDetailId);
                if (orderDetail == null) {
                    orderDetail = new OrderDetailModel();
                    orderDetail.setOrder_detail_id(orderDetailId);
                    orderDetail.setQuantity(rs.getInt("quantity"));
                    orderDetail.setTable_number(rs.getInt("table_number"));
                    orderDetail.setStatus(rs.getInt("order_detail_status"));
                    orderDetail.setProductDetails(new ArrayList<>());
                    orderDetailsMap.put(orderDetailId, orderDetail);
                }

                ProductDetailModel productDetail = new ProductDetailModel();
                productDetail.setProduct_detail_id(rs.getInt("product_detail_id"));
                productDetail.setSize(rs.getString("size"));
                productDetail.setPrice(rs.getFloat("price"));
                productDetail.setProduct_name(rs.getString("product_name"));

                orderDetail.getProductDetails().add(productDetail);
            }

            if (orderModel != null) {
                orderModel.setOrderDetails(new ArrayList<>(orderDetailsMap.values()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) ConnectionCoffee.closeConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderModel;
    }
    

    private static List<ProductDetailModel> getProductDetails(String productDetailIds) {
        List<ProductDetailModel> productDetails = new ArrayList<>();
        Connection conn = ConnectionCoffee.getConnection();
        String query = "SELECT product_detail_id, product_name, price, size FROM product_detail WHERE product_detail_id IN (" + productDetailIds + ")";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProductDetailModel productDetail = new ProductDetailModel();
                productDetail.setProduct_detail_id(rs.getInt("product_detail_id"));
                productDetail.setProduct_name(rs.getString("product_name"));
                productDetail.setPrice(rs.getFloat("price"));
                productDetail.setSize(rs.getString("size"));
                productDetails.add(productDetail);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionCoffee.closeConnection(conn);
        }

        return productDetails;
    }
    
     public static List<PendingBill> getPendingBillsByStatus(int status) {
        List<PendingBill> pendingBills = new ArrayList<>();
        Connection conn = ConnectionCoffee.getConnection();
        String query = "SELECT o.order_id, o.total, o.description, o.day, " +
                       "od.table_number, od.status " +
                       "FROM orders o " +
                       "JOIN order_detail od ON o.order_id = od.order_id " +
                       "WHERE od.status = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, status);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PendingBill bill = new PendingBill();
                bill.setOrder_id(rs.getInt("order_id"));
                bill.setTotal(rs.getFloat("total"));      
                bill.setTable_number(rs.getInt("table_number"));
                bill.setDescription(rs.getString("description"));
                bill.setDay(rs.getDate("day"));
                bill.setStatus(rs.getBoolean("status")); // Set status to false by default
                pendingBills.add(bill);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionCoffee.closeConnection(conn);
        }

        return pendingBills;
    }
}
