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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;
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
    private JButton btnChooseImage;
    private JLabel imageLabel;
    private JPanel buttonPanel;
    private JDialog parentDialog;
    private EmployeeManager employeeManager;

    private HashMap<String, Integer> roleMap;
    private File selectedImageFile;

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
        roleMap.put("Staff", 3);
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255, 102, 0));
        JLabel titleLabel = new JLabel("New Employee", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        titleLabel.setSize(590, 550);
        add(topPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
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
        JLabel lblConfirmPassword = createBoldLabel("Confirm:");
        JLabel lblImage = createBoldLabel("Image:");

        nameField = new JTextField();
        positionComboBox = new JComboBox<>(new String[]{"Staff", "Manager"});
        phoneField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        btnChooseImage = new JButton("Choose Image");
        imageLabel = new JLabel();

        // Set preferred and minimum size for JTextField components
        setFixedHeight(nameField);
        setFixedHeight(phoneField);
        setFixedHeight(emailField);
        setFixedHeight(passwordField);
        setFixedHeight(confirmPasswordField);

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
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1.0; 
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(Color.WHITE);
        formPanel.add(buttonPanel, gbc);

        add(formPanel, BorderLayout.CENTER);
    }

    private void setFixedHeight(JTextField textField) {
        textField.setPreferredSize(new Dimension(textField.getPreferredSize().width, 50));
        textField.setMinimumSize(new Dimension(textField.getMinimumSize().width, 50));
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
        component.setPreferredSize(new Dimension(300, 40)); 
        component.setMinimumSize(new Dimension(300, 40)); 
        }

    private void initAddComponents() {
        btnAction = new JButton("Register");
        btnAction.setBackground(new Color(255, 51, 0));
        btnAction.setForeground(Color.WHITE);
        btnAction.setPreferredSize(new Dimension(150, 35));
        btnAction.setMinimumSize(new Dimension(150, 35));
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddEmployee(e);
            }
        });
        buttonPanel.add(btnAction);
    }

    private void chooseImage() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        selectedImageFile = fileChooser.getSelectedFile();
        String fileName = selectedImageFile.getName();
        imageLabel.setText(getTruncatedFileName(fileName, imageLabel.getFontMetrics(imageLabel.getFont()), imageLabel.getWidth()));
    }
}

    private String getTruncatedFileName(String fileName, FontMetrics fontMetrics, int maxWidth) {
        if (fontMetrics.stringWidth(fileName) <= maxWidth) {
            return fileName;
        }

        String ellipsis = "...";
        int ellipsisWidth = fontMetrics.stringWidth(ellipsis);
        int availableWidth = maxWidth - ellipsisWidth;
        int truncatedWidth = 0;
        int i;

        for (i = 0; i < fileName.length(); i++) {
            truncatedWidth += fontMetrics.charWidth(fileName.charAt(i));
            if (truncatedWidth > availableWidth) {
                break;
            }
        }

        return fileName.substring(0, i) + ellipsis;
    }


    private void handleAddEmployee(ActionEvent e) {
        String fullName = nameField.getText();
        String position = (String) positionComboBox.getSelectedItem();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!FormValidator.validateForm(fullName, position, phone, email, password, confirmPassword)) {
            return;
        }

        if (isEmailExist(email)) {
            JOptionPane.showMessageDialog(this, "Email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer roleId = roleMap.get(position); // Changed to Integer to check for null
        if (roleId == null) {
            JOptionPane.showMessageDialog(this, "Selected role is invalid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String imageName = (selectedImageFile != null) ? saveImage(selectedImageFile) : null;

        try (Connection connection = ConnectionCoffee.getConnection()) {
            if (connection != null) {
                addEmployeeToDatabase(fullName, hashedPassword, phone, roleId, email, imageName, connection);
                resetForm(); // Reset form after successful addition
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to add employee.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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

    private String saveImage(File imageFile) {
        try {
            String extension = "";
            int i = imageFile.getName().lastIndexOf('.');
            if (i > 0) {
                extension = imageFile.getName().substring(i + 1);
            }
            String imageName = UUID.randomUUID().toString() + "." + extension;
            File destFile = new File("src/image/" + imageName);
            Files.copy(imageFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return imageName;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void addEmployeeToDatabase(String fullName, String password, String phone, int roleId, String email, String imageName, Connection connection) throws SQLException {
        String sql = "INSERT INTO Account (username, password, phone, role_id, status, email, image) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, fullName);
            ps.setString(2, password);
            ps.setString(3, phone);
            ps.setInt(4, roleId);
            ps.setInt(5, 1);
            ps.setString(6, email);
            ps.setString(7, imageName);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Employee added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            employeeManager.GetList();
            if (parentDialog != null) {
                parentDialog.dispose();
            }
        }
    }

    private void resetForm() {
        nameField.setText("");
        positionComboBox.setSelectedIndex(0);
        phoneField.setText("");
        emailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        imageLabel.setText("");
        selectedImageFile = null;
    }
}
