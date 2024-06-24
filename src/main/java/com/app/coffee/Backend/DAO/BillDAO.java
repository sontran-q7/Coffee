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
        String query = "SELECT order_detail_id, quantity, total, description, day FROM order_detail";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PendingBill bill = new PendingBill();
                bill.setOrder_detail_id(rs.getInt("order_detail_id"));
                bill.setQuantity(rs.getInt("quantity"));
                bill.setTotal(rs.getFloat("total"));
               // bill.setNo(rs.getInt("no"));
               // bill.setTableNumber(rs.getInt("table_number"));
                bill.setDescription(rs.getString("description"));
                bill.setDay(rs.getDate("day"));
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
