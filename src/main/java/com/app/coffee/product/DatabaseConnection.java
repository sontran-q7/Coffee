/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

//import com.app.coffee.Database.AdminAccountManager;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author anhso
 */
public class DatabaseConnection {
    public static java.sql.Connection getJDBConnection() {
        final String url = "jdbc:mysql://localhost:3306/coffehouse";
        final String user = "root";
        final String password = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
     }
     
     public static void main(String[] args) {
        java.sql.Connection connection = getJDBConnection();
         
        if(connection != null){
//            AdminAccountManager.createAdminAccount();
            System.out.println("success");   
        }else{
            System.out.println("false");
        }
    }

    private PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
