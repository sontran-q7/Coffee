/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.app.coffee;

//import com.app.coffee.Database.AdminAccountManager;
import static com.app.coffee.Login.Login.checkAdminRoleExists;
import static com.app.coffee.Login.Login.showLoginForm;
import static com.app.coffee.Login.Login.showRegisterAdmin;
import com.app.coffee.Login.LoginAccount.LoginForm;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;

/**
 *
 * @author anhso
 */
public class Coffee {

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
}
