/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Login.LoginAccount;


import com.app.coffee.Backend.Model.Role;
import com.app.coffee.Backend.Model.UsersModel;
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
        String sql = "SELECT * FROM account WHERE email = ?";
       
        try (
            java.sql.Connection conn = Connection.getJDBConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, email);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int account_id = rs.getInt("account_id");
                    String username = rs.getString("username");
                    String image = rs.getString("image");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    int role_id = rs.getInt("role_id");
                    int status = rs.getInt("status");
                    Role role = new Role(role_id, "Admin");
                    user = new UsersModel(account_id, username, image,password, phone, role, status, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
