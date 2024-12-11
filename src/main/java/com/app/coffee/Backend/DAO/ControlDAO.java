package com.app.coffee.Backend.DAO;

import com.app.coffee.Backend.Connect.ConnectionCoffee;

import com.app.coffee.dashboard.SessionData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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


  public static int addControl(int workingTimeId, String checkIn, String checkOut, float checkInPay, float checkOutPay, int accountId, String selectedStaffNames) {
    String sql = "INSERT INTO control (working_time_id, check_in, check_out, check_in_pay, check_out_pay, account_id, staff_list) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = ConnectionCoffee.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setInt(1, workingTimeId);
        pstmt.setString(2, checkIn);
        pstmt.setString(3, checkOut);
        pstmt.setFloat(4, checkInPay);
        pstmt.setFloat(5, checkOutPay);
        pstmt.setInt(6, accountId);
        pstmt.setString(7, selectedStaffNames);
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating control failed, no rows affected.");
        }
        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating control failed, no ID obtained.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    }
}

  public static Set<String> getSelectedStaffNames(int controlId) {
    Set<String> selectedStaffNames = new HashSet<>();
    String sql = "SELECT staff_list FROM control WHERE control_id = ?";
    try (Connection conn = ConnectionCoffee.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, controlId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            String staffList = rs.getString("staff_list");
            if (staffList != null && !staffList.isEmpty()) {
                String[] staffArray = staffList.split(", ");
                Collections.addAll(selectedStaffNames, staffArray);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return selectedStaffNames;
}

    
 public static boolean updateControl(int controlId, int workingTimeId, float checkInPay, String selectedStaffNames) {
    String sql = "UPDATE control SET working_time_id = ?, check_in_pay = ?, staff_list = ? WHERE control_id = ?";
    try (Connection conn = ConnectionCoffee.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, workingTimeId);
        pstmt.setFloat(2, checkInPay);
        pstmt.setString(3, selectedStaffNames);
        pstmt.setInt(4, controlId);
        int affectedRows = pstmt.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
 
  public static boolean removeStaffFromControl(int controlId, String staffName) {
        String sql = "UPDATE control SET staff_list = REPLACE(staff_list, ?, '') WHERE control_id = ?";
        try (Connection conn = ConnectionCoffee.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staffName);
            pstmt.setInt(2, controlId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
