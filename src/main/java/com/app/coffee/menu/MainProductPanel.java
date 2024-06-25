/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.menu;

import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class MainProductPanel {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Application");
        
        // Thêm giao diện người dùng 'test' vào JFrame
        ProductPanel productPanel = new ProductPanel();
        frame.getContentPane().add(productPanel);
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    // Vô hiệu hóa khả năng thay đổi kích thước của JFrame
        frame.setResizable(false);
    // Loại bỏ khả năng thu nhỏ cửa sổ bằng cách đặt undecorated
        frame.setUndecorated(true);
    
        // Đặt thuộc tính JFrame setVisible thành true để hiển thị cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
