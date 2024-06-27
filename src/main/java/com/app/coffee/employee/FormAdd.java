package com.app.coffee.employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.swing.*;
import org.mindrot.jbcrypt.BCrypt;

import com.app.coffee.Backend.Connect.ConnectionCoffee;

public class FormAdd extends JPanel {
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

    private HashMap<String, Integer> roleMap;

    public FormAdd(JDialog parentDialog, EmployeeManager employeeManager) {
        this.parentDialog = parentDialog;
        this.employeeManager = employeeManager;
        initComponents();
        initAddComponents();
        initRoleMap();
    }

    private void initRoleMap() {
        roleMap = new HashMap<>();
        roleMap.put("Manager", 2);
        roleMap.put("Barista", 3);
        roleMap.put("Cashier", 4);
        roleMap.put("Customer", 5);
    }

    private void initComponents() {
        setLayout(new BorderLayout(20, 20));
        setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255,102,0));
        JLabel titleLabel = new JLabel("New Employee", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        titleLabel.setSize(490,550);
        add(topPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Added padding
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel lblFullName = createBoldLabel("Full Name:");
        JLabel lblPosition = createBoldLabel("Position:");
        JLabel lblPhone = createBoldLabel("Phone:");
        JLabel lblEmail = createBoldLabel("Email:");
        JLabel lblPassword = createBoldLabel("Password:");
        JLabel lblConfirmPassword = createBoldLabel("Confirm Password:");

        nameField = new JTextField();
        positionComboBox = new JComboBox<>(new String[]{"Manager", "Barista", "Cashier", "Customer"});
        phoneField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        addFormComponent(formPanel, gbc, lblFullName, nameField, 0);
        addFormComponent(formPanel, gbc, lblPosition, positionComboBox, 1);
        addFormComponent(formPanel, gbc, lblPhone, phoneField, 2);
        addFormComponent(formPanel, gbc, lblEmail, emailField, 3);
        addFormComponent(formPanel, gbc, lblPassword, passwordField, 4);
        addFormComponent(formPanel, gbc, lblConfirmPassword, confirmPasswordField, 5);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(Color.WHITE);
        formPanel.add(buttonPanel, gbc);

        add(formPanel, BorderLayout.CENTER);
    }

    private JLabel createBoldLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
    }

    private void addFormComponent(JPanel panel, GridBagConstraints gbc, JLabel label, JComponent component, int y) {
        gbc.gridx = 0;
        gbc.gridy = y;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(component, gbc);
        component.setPreferredSize(new Dimension(300, 30));
    }

    private void initAddComponents() {
        btnAction = new JButton("Register");
        btnAction.setBackground(new Color(255, 51, 0));
        btnAction.setForeground(Color.WHITE);
        btnAction.setPreferredSize(new Dimension(200, 40));
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddEmployee(e);
            }
        });
        buttonPanel.add(btnAction);
    }

    private void handleAddEmployee(ActionEvent e) {
        String fullName = nameField.getText();
        String position = (String) positionComboBox.getSelectedItem();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (isFormInvalid(fullName, position, phone, email, password, confirmPassword)) return;

        if (isEmailExist(email)) {
            JOptionPane.showMessageDialog(this, "Email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int roleId = roleMap.get(position);
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try (Connection connection = ConnectionCoffee.getConnection()) {
            if (connection != null) {
                addEmployeeToDatabase(fullName, hashedPassword, phone, roleId, email, connection);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to add employee.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isFormInvalid(String fullName, String position, String phone, String email, String password, String confirmPassword) {
        if (fullName.isEmpty() || position.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        if (!phone.matches("^0\\d{8,}$")) {
            JOptionPane.showMessageDialog(this, "The phone number always starts with 0 and must have at least 8 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private boolean isEmailExist(String email) {
        String sql = "SELECT COUNT(*) FROM Account WHERE email = ?";
        try (Connection connection = ConnectionCoffee.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void addEmployeeToDatabase(String fullName, String password, String phone, int roleId, String email, Connection connection) throws SQLException {
        String sql = "INSERT INTO Account (username, password, phone, role_id, status, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, fullName);
            ps.setString(2, password);
            ps.setString(3, phone);
            ps.setInt(4, roleId);
            ps.setInt(5, 1);
            ps.setString(6, email);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            employeeManager.GetList();
            if (parentDialog != null) {
                parentDialog.dispose();
            }
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
