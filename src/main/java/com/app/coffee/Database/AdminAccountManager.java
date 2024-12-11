///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.app.coffee.Database;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import org.mindrot.jbcrypt.BCrypt;
//
///**
// *
// * @author Admin
// */
//public class AdminAccountManager {
//    private static final String url = "jdbc:mysql://localhost:3306/coffehouse";
//    private static final String user = "root";
//    private static final String password = "";
//
//    public static boolean isAdminAccountExist() {
//        try (java.sql.Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM account WHERE role_id = 1")) {
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    int count = rs.getInt(1);
//                    return count > 0;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public static String hashPassword(String password) {
//        return BCrypt.hashpw(password, BCrypt.gensalt());
//    }
//
//    public static void createAdminAccount() {
//        if (!isAdminAccountExist()) {
//            try {
//                String adminPassword = "admin";
//                String hashedPassword = hashPassword(adminPassword);
//
//                try (java.sql.Connection conn = DriverManager.getConnection(url, user, password);
//                     PreparedStatement stmt = conn.prepareStatement("INSERT INTO account (username, image, email, password, phone, role_id, status) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
//                    stmt.setString(1, "admin");
//                    stmt.setString(2, ""); 
//                    stmt.setString(3, "admin@gmail.com");
//                    stmt.setString(4, hashedPassword);
//                    stmt.setInt(5, 0);
//                    stmt.setInt(6, 1); 
//                    stmt.setInt(7, 1); 
//
//                    int rowsInserted = stmt.executeUpdate();
//                    if (rowsInserted > 0) {
//                        System.out.println("A new admin account was created successfully!");
//                    }
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Admin account already exists.");
//        }
//    }
//}
