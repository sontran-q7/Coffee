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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.app.coffee.Backend.Connect.ConnectionCoffee;
import com.app.coffee.Backend.Model.UsersModel;

public class FormEdit extends JPanel {
    private JTextField nameField;
    private JComboBox<String> positionComboBox;
    private JTextField phoneField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton btnAction;
    private JPanel buttonPanel;
    private JDialog parentDialog;
    private EmployeeManager employeeManager;
    private UsersModel userModel;

    // Role mapping
    private HashMap<String, Integer> roleMap;

    public FormEdit(JDialog parentDialog, EmployeeManager employeeManager, UsersModel userModel) {
        this.parentDialog = parentDialog;
        this.employeeManager = employeeManager;
        this.userModel = userModel;
        initComponents();
        initEditComponents();
        initRoleMap();
        populateFields();
    }

    private void initRoleMap() {
        roleMap = new HashMap<>();
        roleMap.put("Manager", 2);
        roleMap.put("Barista", 3);
        roleMap.put("Cashier", 4);
        roleMap.put("Customer", 5);
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255, 51, 0));
        topPanel.setForeground(Color.WHITE);
        JLabel titleLabel = new JLabel("Edit Employee", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(topPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel lblFullName = new JLabel("Full Name:");
        JLabel lblPosition = new JLabel("Position:");
        JLabel lblPhone = new JLabel("Phone:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblConfirmPassword = new JLabel("Confirm Password:");

        nameField = new JTextField();
        positionComboBox = new JComboBox<>(new String[] {"Manager", "Barista", "Cashier", "Customer"});
        phoneField = new JTextField();
        phoneField.setText("84");
        emailField = new JTextField();
        emailField.setEditable(false);
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

        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(formPanel, BorderLayout.CENTER);
    }

    private void initEditComponents() {
        btnAction = new JButton("Save");
        btnAction.setBackground(new Color(255, 51, 0));
        btnAction.setForeground(Color.WHITE);
        btnAction.setSize(140, 40);
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPerformedEdit(e);
            }
        });
        buttonPanel.add(btnAction);
    }

    private void populateFields() {
        nameField.setText(userModel.getUsername());
        positionComboBox.setSelectedItem(userModel.getRole().getName());
        phoneField.setText(String.valueOf(userModel.getPhone())); // Convert int to String
        emailField.setText(userModel.getEmail());
    }

    private void actionPerformedEdit(ActionEvent e) {
        String fullName = nameField.getText();
        String position = (String) positionComboBox.getSelectedItem();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (fullName.isEmpty() || position.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!phone.matches("^\\d{8,}$")) {
            JOptionPane.showMessageDialog(this, "Phone number must have at least 8 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int roleId = roleMap.get(position);

        Connection connection = ConnectionCoffee.getConnection();
        if (connection != null) {
            String sql;

            if (!password.isEmpty() || !confirmPassword.isEmpty()) {
                if (password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in the password fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                sql = "UPDATE Account SET username = ?, password = ?, phone = ?, role_id = ?, email = ? WHERE account_id = ?";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setString(1, fullName);
                    ps.setString(2, password);
                    ps.setString(3, phone);
                    ps.setInt(4, roleId);
                    ps.setString(5, email);
                    ps.setInt(6, userModel.getAccount_id());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to update employee.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                sql = "UPDATE Account SET username = ?, phone = ?, role_id = ?, email = ? WHERE account_id = ?";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setString(1, fullName);
                    ps.setString(2, phone);
                    ps.setInt(3, roleId);
                    ps.setString(4, email);
                    ps.setInt(5, userModel.getAccount_id());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to update employee.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Employee updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            employeeManager.GetList();
            parentDialog.dispose();
        }
    }
}
