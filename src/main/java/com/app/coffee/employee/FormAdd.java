/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.employee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author phamv
 */
public class FormAdd extends JPanel{
    private JTextField nameField;
    private JComboBox<String> positionComboBox;
    private JTextField phoneField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton btnAction;
    private JPanel buttonPanel;

    public FormAdd() {
        initComponents();
        initAddComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));  

        // Create the top panel with the title
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255,51,0));  
        topPanel.setForeground(Color.WHITE);
        JLabel titleLabel = new JLabel("New Employee", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Add padding around the top panel
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(topPanel, BorderLayout.NORTH);

        // Create the form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make components fill horizontally
        gbc.weightx = 1.0; // Allocate extra horizontal space

        JLabel lblFullName = new JLabel("Full Name:");
        JLabel lblPosition = new JLabel("Chức vụ:");
        JLabel lblPhone = new JLabel("Phone:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblConfirmPassword = new JLabel("ConfinPassword:");

        nameField = new JTextField();
        positionComboBox = new JComboBox<>(new String[] {"Manager", "Order"});
        phoneField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblFullName, gbc);

        gbc.gridx = 1;
        formPanel.add(nameField, gbc);
        nameField.setPreferredSize(new Dimension(200, 25));

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lblPosition, gbc);

        gbc.gridx = 1;
        formPanel.add(positionComboBox, gbc);
        positionComboBox.setPreferredSize(new Dimension(200, 25));

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lblPhone, gbc);

        gbc.gridx = 1;
        formPanel.add(phoneField, gbc);
        phoneField.setPreferredSize(new Dimension(200, 25));

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(lblEmail, gbc);

        gbc.gridx = 1;
        formPanel.add(emailField, gbc);
        emailField.setPreferredSize(new Dimension(200, 25));

        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(lblPassword, gbc);

        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);
        passwordField.setPreferredSize(new Dimension(200, 25));

        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(lblConfirmPassword, gbc);

        gbc.gridx = 1;
        formPanel.add(confirmPasswordField, gbc);
        confirmPasswordField.setPreferredSize(new Dimension(200, 25));

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        formPanel.add(buttonPanel, gbc);

        // Add padding around the form panel
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(formPanel, BorderLayout.CENTER);
    }

    private void initAddComponents() {
        btnAction = new JButton("Register");
        btnAction.setBackground(new Color(255,51,0));
        btnAction.setForeground(Color.WHITE);
        btnAction.setSize(140,40);
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Chưa làm!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(btnAction);
    }

    private void actionPerformed(ActionEvent e) {
        String fullName = nameField.getText();
        String position = (String) positionComboBox.getSelectedItem();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (fullName.isEmpty() || position.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Employee added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

}
