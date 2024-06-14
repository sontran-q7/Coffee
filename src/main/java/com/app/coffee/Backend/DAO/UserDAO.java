/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.DAO;

import com.app.coffee.Backend.Connect.ConnectionCoffee;

import com.app.coffee.Backend.Model.UsersModel;
import com.app.coffee.Database.PasswordUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
         try {
        Connection conn = ConnectionCoffee.getConnection();    
        String sql = "UPDATE users SET userName=?, gender=?, phone=?, image=?, password=?, option=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);                
        ps.setString(1, t.getUserName());
        ps.setString(2, t.getGender());
        ps.setInt(3, t.getPhone());
        ps.setString(4, t.getImage());
        String hashedPassword = PasswordUtils.hashPassword(t.getPassword());
        ps.setString(5, hashedPassword);
        ps.setString(6, t.getOption());
        ps.setInt(7, t.getId()); 
        
        int results = ps.executeUpdate();
        System.out.println("Successfully updated user with ID " + t.getId());
        
        ps.close();
        ConnectionCoffee.closeConnection(conn);
        
        return results;
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
    }

    @Override
    public int Delete(UsersModel t) {
        try {
        Connection conn = ConnectionCoffee.getConnection();
        String sql = "DELETE FROM users WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, t.getId());
        
        int results = ps.executeUpdate();
        ps.close();
        ConnectionCoffee.closeConnection(conn);
        
        return results;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
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

    @Override
    public UsersModel selectById(UsersModel t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<UsersModel> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
    

