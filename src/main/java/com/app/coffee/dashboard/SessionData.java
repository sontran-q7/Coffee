/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.dashboard;

import com.app.coffee.Login.LoginAccount.UserSession;

/**
 *
 * @author anhso
 */
public class SessionData {
     private static int controlId = -1; // Khởi tạo giá trị mặc định

    public static int getControlId() {
        return controlId;
    }

     public static void setControlId(int id) {
        controlId = id;
    }

    public static void reset() {
        controlId = -1;
    }
}
