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
import com.app.coffee.Backend.Model.PendingBill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BillDAO {

    public static List<PendingBill> getPendingBills() {
        List<PendingBill> pendingBills = new ArrayList<>();
    Connection conn = ConnectionCoffee.getConnection();
    String query = "SELECT o.order_id, SUM(o.total) as total, GROUP_CONCAT(o.description SEPARATOR ', ') as description, " +
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
}
