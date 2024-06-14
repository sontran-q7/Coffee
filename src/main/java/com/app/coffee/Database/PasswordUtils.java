/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Database;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author Admin
 */
 
public class PasswordUtils {
    public static boolean checkPassword(String enteredPassword, String storedPasswordHash) {
        try {
            String hashedEnteredPassword = hashPassword(enteredPassword);
            return hashedEnteredPassword.equals(storedPasswordHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}