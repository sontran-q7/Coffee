/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.DAO;

import com.app.coffee.Backend.Connect.ConnectionCoffee;

import com.app.coffee.Backend.Model.UsersModel;
import com.app.coffee.Database.PasswordUtils;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class UserDAO implements DAOInterface<UsersModel>{

    public static UserDAO getInstance(){
        return new UserDAO();
    }
    @Override
    public int Create(UsersModel t) {
        try {
            Connection conn = ConnectionCoffee.getConnection();    
            String sql = "INSERT INTO users (userName, gender, phone, image, email, password, option, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
                     
            ps.setString(1, t.getUserName());
            ps.setString(2, t.getGender());
            ps.setInt(3, t.getPhone());
            ps.setString(4, t.getImage());
            ps.setString(5, t.getEmail());
            String hashedPassword = PasswordUtils.hashPassword(t.getPassword());
            ps.setString(6, hashedPassword);
            ps.setString(7, t.getOption());
            ps.setBoolean(8, t.getStatus());
            int results = ps.executeUpdate();
            System.out.println("Successfully! " + t);
            
            ps.close();
            ConnectionCoffee.closeConnection(conn);
            
            return results;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Update(UsersModel t) {      
       try (Connection conn = ConnectionCoffee.getConnection()) {
        String sql = "UPDATE users SET userName=?, gender=?, phone=?, image=?, email=?, password=?, option=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, t.getUserName());
        ps.setString(2, t.getGender());
        ps.setInt(3, t.getPhone());
        ps.setString(4, t.getImage());
        ps.setString(5, t.getEmail());
       try {
            String hashedPassword = PasswordUtils.hashPassword(t.getPassword());
            ps.setString(6, hashedPassword); 
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error hashing password: " + e.getMessage());
            return 0; 
        }
        ps.setString(7, t.getOption());
        ps.setInt(8, t.getId());

        int results = ps.executeUpdate();
        System.out.println("Successfully updated user with ID " + t.getId());

        ps.close(); 
        ConnectionCoffee.closeConnection(conn); 

        return results; 
    } catch (SQLException e) {
        e.printStackTrace();
    } 
    return 0;
    }

    
    public int Delete(int userId) {
    return 0;
    }

    public int DeleteByStatus(int userId) {
    try (Connection conn = ConnectionCoffee.getConnection();
         PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE id=?")) {
        
        ps.setInt(1, userId);
        
        int results = ps.executeUpdate();
        
        return results;
        
    } catch (SQLException e) {
        e.printStackTrace();
       
    } catch (Exception e) {
        e.printStackTrace();
       
    }
    return 0;
}
    
    public boolean checkEmailExists(String email) {
    String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
    try (Connection conn = ConnectionCoffee.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, email);
        try (ResultSet rs = ps.executeQuery()) {
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
    
    @Override
    public ArrayList<UsersModel> selectAll() {
       ArrayList<UsersModel> listUser = new ArrayList<>();
    try {
        Connection conn = ConnectionCoffee.getConnection();
        String sql = "SELECT * FROM users";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            UsersModel user = new UsersModel();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("userName"));
            user.setGender(rs.getString("gender"));
            user.setPhone(rs.getInt("phone"));
            user.setImage(rs.getString("image"));
            user.setEmail(rs.getString("email"));
            user.setOption(rs.getString("option"));
            
            listUser.add(user);
        }
        rs.close();
        ps.close();
        ConnectionCoffee.closeConnection(conn);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listUser;
    }

    public UsersModel selectById(int userId) {
        UsersModel user = null;
        
        String query = "SELECT * FROM Users WHERE id = ?";
        
        try (Connection conn = ConnectionCoffee.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new UsersModel();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getString("gender"));
                user.setPhone(rs.getInt("phone"));
                user.setImage(rs.getString("image"));
                user.setEmail(rs.getString("email"));
                user.setPassWord(rs.getString("password"));
                user.setOption(rs.getString("option"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
     
    }

    @Override
    public ArrayList<UsersModel> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public UsersModel selectById(UsersModel t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int Delete(UsersModel t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    

