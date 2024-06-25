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
import java.util.ArrayList;
import java.util.List;


public class BillDAO {

    public static List<PendingBill> getPendingBills() {
        List<PendingBill> pendingBills = new ArrayList<>();
        Connection conn = ConnectionCoffee.getConnection();
        String query = "SELECT order_detail_id,  total, description,table_number, day,status FROM order_detail";
// quantity
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PendingBill bill = new PendingBill();
                bill.setOrder_detail_id(rs.getInt("order_detail_id"));
               // bill.setQuantity(rs.getInt("quantity"));
                bill.setTotal(rs.getFloat("total"));
               // bill.setNo(rs.getInt("no"));
                bill.setTable_number(rs.getInt("table_number"));
                bill.setDescription(rs.getString("description"));
                bill.setDay(rs.getDate("day"));
                bill.setStatus(false);
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
                           "FROM order_detail " +
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
}
