/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Login;

//import com.app.coffee.Database.AdminAccountManager;
import com.app.coffee.Login.LoginAccount.LoginForm;
import com.app.coffee.Login.LoginAccount.SendAdmin;
import com.app.coffee.Login.LoginAccount.SendCode;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author anhso
 */
public class Login {
    public static void main(String[] args) {
        FlatLaf.registerCustomDefaultsSource("com.app.coffee.employee");
        //FlatMacDarkLaf.setup();
        FlatIntelliJLaf.setup();
//        AdminAccountManager.createAdminAccount();
       if (!checkAdminRoleExists()) {
        
            showRegisterAdmin();
        } else {
            
            showLoginForm();
        }

    }

    public static void showLoginForm() {
        LoginForm loginForm = new LoginForm();
        loginForm.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        loginForm.setVisible(true);
    }
    
    public static void showRegisterAdmin() {
        SendAdmin sendAdminPanel = new SendAdmin();
        JFrame frame = new JFrame("Send Admin Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(sendAdminPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    public static boolean checkAdminRoleExists() {
        boolean exists = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/coffehouse", "root", "");
            String query = "SELECT COUNT(*) AS count FROM account WHERE role_id = 1";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    exists = true;
                }
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
        return exists;
    }
    
   
}
