/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Database;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class AdminAccountManager {
    private static final String url = "jdbc:mysql://localhost:3306/coffehouse";
    private static final String user = "root";
    private static final String password = "";

   
    public static boolean isAdminAccountExist() {
        try (java.sql.Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM account WHERE role_id = '1'")) {
            try (ResultSet rs = stmt.executeQuery()) {
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

     public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    

    public static void createAdminAccount() {
        if (!isAdminAccountExist()) {
            try {
                String adminPassword = "admin";
                String hashedPassword = hashPassword(adminPassword);

                try (java.sql.Connection conn = DriverManager.getConnection(url, user, password);
                     PreparedStatement stmt = conn.prepareStatement("INSERT INTO account (username, password, phone, role_id, status, email) VALUES (?, ?, ?, ?, ?, ?)")) {
                    stmt.setString(1, "admin");
                    stmt.setString(2, hashedPassword);
                    stmt.setInt(3, 0);
                    stmt.setInt(4, 1); // Assuming 1 is the role_id for Admin
                    stmt.setInt(5, 1); // Assuming 1 means active status
                    stmt.setString(6, "admin@gmail.com");

                    int rowsInserted = stmt.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new admin account was created successfully!");
                    }
                }
            } catch (SQLException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Admin account already exists.");
        }
    }
    
}
