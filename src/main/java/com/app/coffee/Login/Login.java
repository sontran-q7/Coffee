/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Login;

import com.app.coffee.Database.AdminAccountManager;
import com.app.coffee.Login.LoginAccount.LoginForm;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;

/**
 *
 * @author anhso
 */
public class Login {
    public static void main(String[] args) {
        FlatLaf.registerCustomDefaultsSource("com.app.coffee.employee");
        //FlatMacDarkLaf.setup();
        FlatIntelliJLaf.setup();
        AdminAccountManager.createAdminAccount();
        showLoginForm();
    }

    public static void showLoginForm() {
        LoginForm loginForm = new LoginForm();
        loginForm.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        loginForm.setVisible(true);
    }
}
