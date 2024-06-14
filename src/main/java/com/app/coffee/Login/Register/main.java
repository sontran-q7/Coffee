/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Login.Register;


import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Create User");
        
        ListUsers Test = new ListUsers();
        frame.getContentPane().add(Test);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
