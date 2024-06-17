/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Login;

import com.app.coffee.Database.AdminAccountManager;
import com.app.coffee.Login.LoginAccount.LoginForm;

/**
 *
 * @author anhso
 */
public class Login {
    public static void main(String[] args) {
      AdminAccountManager.createAdminAccount();
      LoginForm loginForm = new LoginForm();
      loginForm.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        loginForm.setVisible(true);
    }
}
