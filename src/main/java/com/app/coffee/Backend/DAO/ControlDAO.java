package com.app.coffee.Backend.DAO;

import com.app.coffee.Backend.Connect.ConnectionCoffee;

import com.app.coffee.dashboard.SessionData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlDAO {
   public static void updateControl(int controlId, float checkOutPay, String checkOutTime) {
    String sql = "UPDATE control SET check_out_pay = ?, check_out = ? WHERE control_id = ?";
    try (Connection conn = ConnectionCoffee.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setFloat(1, checkOutPay);
        pstmt.setString(2, checkOutTime);
        pstmt.setInt(3, controlId);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public static int addControl(int workingTimeId, String checkIn, String checkOut, float checkInPay, float checkOutPay, int accountId) {
        String sql = "INSERT INTO control (working_time_id, check_in, check_out, check_in_pay, check_out_pay, account_id) VALUES (?, ?, ?, ?, ?, ?)";
        int controlId = -1;
        try (Connection conn = ConnectionCoffee.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, workingTimeId);
            pstmt.setString(2, checkIn);
            pstmt.setString(3, checkOut);
            pstmt.setFloat(4, checkInPay);
            pstmt.setFloat(5, checkOutPay);
            pstmt.setInt(6, accountId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        controlId = generatedKeys.getInt(1);
                        SessionData.setControlId(controlId); // Lưu controlId vào SessionData
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return controlId;
    }
    
      public static boolean updateControl(int controlId, int workingTimeId, float checkInPay) {
        String query = "UPDATE control SET working_time_id = ?, check_in_pay = ? WHERE control_id = ?";
        try (Connection conn = ConnectionCoffee.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, workingTimeId);
            ps.setFloat(2, checkInPay);
            ps.setInt(3, controlId);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
