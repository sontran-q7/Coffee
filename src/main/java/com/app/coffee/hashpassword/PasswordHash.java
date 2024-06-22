/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.hashpassword;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author phamv
 */
public class PasswordHash {
    public static boolean checkPassword(String plaintextPassword, String hashedPassword) {
        if (hashedPassword == null || !hashedPassword.startsWith("$2a$")) {
            throw new IllegalArgumentException("Invalid hashed password");
        }
        return BCrypt.checkpw(plaintextPassword, hashedPassword);
    }
}
