/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Login.LoginAccount;


import com.app.coffee.Database.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class UserController {
    public UsersModel getUserByEmail(String email) {
        UsersModel user = null;
        String sql = "SELECT * FROM users WHERE email = ?";
       
        try (
            java.sql.Connection conn = Connection.getJDBConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, email);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String userName = rs.getString("userName");
                    int gender = rs.getInt("gender");
                    int phone = rs.getInt("phone");
                    String image = rs.getString("image");
                    String password = rs.getString("password");
                    String option = rs.getString("option");
                    
                    user = new UsersModel(id, userName, gender, phone, image, email, password, option);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
