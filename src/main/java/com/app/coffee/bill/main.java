/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.bill;

import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class main {
    public static void main(String[] args) {
      
         JFrame frame = new JFrame("Test Application");
        
        // Thêm giao diện người dùng 'test' vào JFrame
        test Test = new test();
        frame.getContentPane().add(Test);
        
        // Đặt thuộc tính JFrame setVisible thành true để hiển thị cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
       
    }
}
