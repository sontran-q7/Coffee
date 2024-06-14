/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ConnectionCoffee {
    public static Connection getConnection() {
        Connection c = null;
   
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            String url = "jdbc:mysql://localhost:3306/ap";
            final String user = "root";
            final String password = "";
            
            c = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
       return c;
    }
    public static void closeConnection(Connection c){
        try {
            if(c != null){
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
