/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.app.coffee;

import com.app.coffee.Database.AdminAccountManager;
import com.app.coffee.Login.LoginAccount.LoginForm;

/**
 *
 * @author anhso
 */
public class Coffee {

      public static void main(String[] args) {
        AdminAccountManager.createAdminAccount();
        showLoginForm();
    }

    public static void showLoginForm() {
        LoginForm loginForm = new LoginForm();
        loginForm.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        loginForm.setVisible(true);
    }
}
