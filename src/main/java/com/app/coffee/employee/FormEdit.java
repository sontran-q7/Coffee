package com.app.coffee.employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;
import javax.swing.*;
import org.mindrot.jbcrypt.BCrypt;

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
    private JButton btnChooseImage;
    private JLabel imageLabel;
    private JPanel buttonPanel;
    private JDialog parentDialog;
    private EmployeeManager employeeManager;
    private UsersModel userModel;

    private HashMap<String, Integer> roleMap;
    private File selectedImageFile;

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
        roleMap.put("Staff", 2);    
        roleMap.put("Customer", 3);
    }

    private void initComponents() {
        setLayout(new BorderLayout(20, 20));
        setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255, 102, 0));
        JLabel titleLabel = new JLabel("Edit Employee", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
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
        JLabel lblImage = createBoldLabel("Image:");

        nameField = new JTextField();
        positionComboBox = new JComboBox<>(new String[]{"Staff", "Customer"});
        phoneField = new JTextField();
        emailField = new JTextField();
        emailField.setEditable(false);
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        btnChooseImage = new JButton("Choose Image");
        imageLabel = new JLabel();

        btnChooseImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseImage();
            }
        });

        addFormComponent(formPanel, gbc, lblFullName, nameField, 0);
        addFormComponent(formPanel, gbc, lblPosition, positionComboBox, 1);
        addFormComponent(formPanel, gbc, lblPhone, phoneField, 2);
        addFormComponent(formPanel, gbc, lblEmail, emailField, 3);
        addFormComponent(formPanel, gbc, lblPassword, passwordField, 4);
        addFormComponent(formPanel, gbc, lblConfirmPassword, confirmPasswordField, 5);
        addFormComponent(formPanel, gbc, lblImage, btnChooseImage, 6);

        gbc.gridx = 1;
        gbc.gridy = 7;
        formPanel.add(imageLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
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

    private void initEditComponents() {
        btnAction = new JButton("Save");
        btnAction.setBackground(new Color(255, 51, 0));
        btnAction.setForeground(Color.WHITE);
        btnAction.setPreferredSize(new Dimension(200, 40));
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEditEmployee(e);
            }
        });
        buttonPanel.add(btnAction);
    }

    private void populateFields() {
        nameField.setText(userModel.getUsername());
        positionComboBox.setSelectedItem(userModel.getRole().getName());
        phoneField.setText(userModel.getPhone());
        emailField.setText(userModel.getEmail());
        if (userModel.getImage() != null) {
            selectedImageFile = new File("src/image/" + userModel.getImage());
            Image img = new ImageIcon(selectedImageFile.getAbsolutePath()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        }
    }

    private void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedImageFile = fileChooser.getSelectedFile();
            try {
                Image img = new ImageIcon(selectedImageFile.getAbsolutePath()).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void handleEditEmployee(ActionEvent e) {
        String fullName = nameField.getText();
        String position = (String) positionComboBox.getSelectedItem();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!FormValidator.validateEditForm(fullName, position, phone, email, password, confirmPassword)) {
            return;
        }

        Integer roleId = roleMap.get(position);
        if (roleId == null) {
            JOptionPane.showMessageDialog(this, "Selected role is invalid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection connection = ConnectionCoffee.getConnection();
        if (connection != null) {
            String sql;
            if (!password.isEmpty() || !confirmPassword.isEmpty()) {
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                sql = "UPDATE Account SET username = ?, password = ?, phone = ?, role_id = ?, email = ?, image = ? WHERE account_id = ?";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setString(1, fullName);
                    ps.setString(2, hashedPassword);
                    ps.setString(3, phone);
                    ps.setInt(4, roleId);
                    ps.setString(5, email);
                    String imageName = saveImage(selectedImageFile);
                    if (imageName != null) {
                        ps.setString(6, imageName);
                    } else {
                        ps.setNull(6, java.sql.Types.VARCHAR);
                    }
                    ps.setInt(7, userModel.getAccount_id());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to update employee.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                sql = "UPDATE Account SET username = ?, phone = ?, role_id = ?, email = ?, image = ? WHERE account_id = ?";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setString(1, fullName);
                    ps.setString(2, phone);
                    ps.setInt(3, roleId);
                    ps.setString(4, email);
                    String imageName = saveImage(selectedImageFile);
                    if (imageName != null) {
                        ps.setString(5, imageName);
                    } else {
                        ps.setNull(5, java.sql.Types.VARCHAR);
                    }
                    ps.setInt(6, userModel.getAccount_id());
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to update employee.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Employee updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            employeeManager.GetList();
            if (parentDialog != null) {
                parentDialog.dispose();
            }
        }
    }

    private String saveImage(File imageFile) {
        if (imageFile != null) {
            try {
                // Generate a random name for the image file
                String extension = imageFile.getName().substring(imageFile.getName().lastIndexOf("."));
                String imageName = UUID.randomUUID().toString() + extension;

                // Delete the old image file if it exists
                if (userModel.getImage() != null && !userModel.getImage().isEmpty()) {
                    File oldImageFile = new File("src/image/" + userModel.getImage());
                    if (oldImageFile.exists()) {
                        oldImageFile.delete();
                    }
                }

                File destFile = new File("src/image/" + imageName);
                Files.copy(imageFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                return imageName;
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return userModel.getImage();
    }
}
