/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

import javax.swing.*;

/**
 *
 * @author Acer
 */
public class EditCategoryForm extends javax.swing.JFrame {
    private final String ID;
    private final ProductForm parentForm;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JButton btnSave, btnCancel;
        
    public EditCategoryForm(String ID, String category, String description, ProductForm parentForm) {
        initComponents();
        this.ID = ID;
        this.parentForm = parentForm;
        txtCategory.setText(category);
        txtDescription.setText(description);
    }

    // Generated code for UI components
    // (txtCategoryName, txtCategoryDescription, btnSave, btnCancel)

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Lấy thông tin chỉnh sửa từ các trường dữ liệu trên form
        String newName = txtCategory.getText();
        String newDescription = txtDescription.getText();
        
        // Thực hiện cập nhật trong cơ sở dữ liệu
        CategoryDao categoryDao = new CategoryDao();
        if (categoryDao.updateCategory(ID, newName, newDescription)) {
            // Cập nhật thành công, thông báo và cập nhật bảng
            JOptionPane.showMessageDialog(this, "Cập nhật thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            parentForm.updateCategoryTable();
            this.dispose(); // Đóng cửa sổ chỉnh sửa
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }                                        

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose(); // Đóng cửa sổ chỉnh sửa nếu người dùng huỷ bỏ
    }                                         

    private void initComponents() {
        // Khởi tạo các thành phần giao diện
        txtCategory = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        // Thiết lập các thuộc tính cho frame
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Thiết lập layout của frame
        getContentPane().setLayout(new java.awt.FlowLayout());

        // Thêm các thành phần vào frame
        getContentPane().add(txtCategory);
        getContentPane().add(txtDescription);
        getContentPane().add(btnSave);
        getContentPane().add(btnCancel);

        // Thiết lập sự kiện cho các nút
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Lấy thông tin chỉnh sửa từ các trường dữ liệu trên form
                String newName = txtCategory.getText();
                String newDescription = txtDescription.getText();

                // Thực hiện cập nhật trong cơ sở dữ liệu
                CategoryDao categoryDao = new CategoryDao();
                if (categoryDao.updateCategory(ID, newName, newDescription)) {
                    // Cập nhật thành công, thông báo và cập nhật bảng trong ProductForm
//                    JOptionPane.showMessageDialog(this, "Cập nhật thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.showMessageDialog(parentForm, "Cập nhật thành công.");
                    parentForm.updateCategoryTable(); // Cập nhật bảng dữ liệu trong ProductForm
//                    this.dispose(); // Đóng cửa sổ chỉnh sửa
                } else {
                    JOptionPane.showMessageDialog(parentForm, "Cập nhật không thành công!");
                }
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        // Thiết lập tiêu đề và kích thước cho frame
        setTitle("Edit Category");
        setSize(400, 300);
        setLocationRelativeTo(null);
    }
}