/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Admin
 */
public class CustomDialog extends JDialog {
    public CustomDialog(JFrame parent, String title, String message) {
        super(parent, title, true);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.WHITE); // Màu nền cho panel

        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.BLACK); // Màu cho chữ label
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(Color.WHITE); // Màu nền cho button panel

        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Arial", Font.PLAIN, 16));
        closeButton.setBackground(new Color(243, 114, 44)); // Màu nền cho nút Close
        closeButton.setForeground(Color.WHITE); // Màu chữ cho nút Close
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Thiết kế nút Close với góc bo tròn
        closeButton.setPreferredSize(new Dimension(100, 40));
        closeButton.setBorder(new CompoundBorder(
                new LineBorder(Color.WHITE, 2), // Viền ngoài màu trắng cho nút
                new EmptyBorder(5, 15, 5, 15) // Khoảng cách giữa viền và văn bản
        ));
        
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}
