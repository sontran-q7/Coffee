package com.app.coffee.Backend.DAO;

import com.app.coffee.Backend.Connect.ConnectionCoffee;

import com.app.coffee.dashboard.SessionData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControlDAO {
    public static void updateControl(int controlId, float checkOutPay) {
        String query = "UPDATE control SET check_out_pay = ? WHERE control_id = ?";
        try (Connection conn = ConnectionCoffee.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setFloat(1, checkOutPay);
            pstmt.setInt(2, controlId);
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
}
