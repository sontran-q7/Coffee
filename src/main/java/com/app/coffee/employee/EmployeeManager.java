/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.employee;

import com.app.coffee.Backend.DAO.UserDAO;
import com.app.coffee.Backend.Model.UsersModel;
import com.app.coffee.design.TableGradient;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phamv
 */
public class EmployeeManager extends javax.swing.JPanel {

    public EmployeeManager() {
        initComponents();
        setDefTable();
        
        GetList();
    }
    
    private void setDefTable() {
        tableListUser.setDefaultRenderer(Object.class, new TableGradient(new Color(243,114,44),new Color(243,114,44)));
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tableListUser.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        scroll.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
    }
    
    public void GetList() {
    UserDAO userdao = new UserDAO();
    ArrayList<UsersModel> listUser = userdao.selectAll();

    // Sort users by account_id
    Collections.sort(listUser, new Comparator<UsersModel>() {
        @Override
        public int compare(UsersModel u1, UsersModel u2) {
            return u1.getAccount_id() - u2.getAccount_id();
        }
    });

    DefaultTableModel table = (DefaultTableModel) tableListUser.getModel();
    table.setRowCount(0);

    for (UsersModel user : listUser) {
        
        if (user.getStatus() == 1) {
            Object[] row = {
                user.getAccount_id(),
                user.getUserName() != null ? user.getUserName() : "",
                user.getRole() != null ? user.getRole().getName() : "", 
                user.getPhone() != 0 ? String.valueOf(user.getPhone()) : "",
                user.getEmail() != null ? user.getEmail() : ""     
            };
            table.addRow(row);
        }
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tableListUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        editAccount = new javax.swing.JButton();
        DeleteEmploy = new javax.swing.JButton();
        AddAccount = new javax.swing.JButton();

        jPanel1.setLayout(new java.awt.BorderLayout());

        tableListUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Position", "Phone", "Email"
            }
        ));
        tableListUser.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tableListUser);
        if (tableListUser.getColumnModel().getColumnCount() > 0) {
            tableListUser.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableListUser.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableListUser.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableListUser.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jPanel1.add(scroll, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Employee Management");

        editAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editAccount.setText("Edit");
        editAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAccountActionPerformed(evt);
            }
        });

        DeleteEmploy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteEmploy.setText("Delete");
        DeleteEmploy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmployActionPerformed(evt);
            }
        });

        AddAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddAccount.setText("Add");
        AddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteEmploy, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DeleteEmploy, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAccountActionPerformed
        int selectedRow = tableListUser.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int userId = (int) tableListUser.getValueAt(selectedRow, 0);
        UserDAO userdao = new UserDAO();
        UsersModel userModel = userdao.selectById(userId);

        if (userModel != null) {
            showFormEditDialog(userModel);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to retrieve user details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editAccountActionPerformed

    private void DeleteEmployActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEmployActionPerformed
        deleteAccount();
    }//GEN-LAST:event_DeleteEmployActionPerformed

    private void AddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAccountActionPerformed
        showFormAddDialog();
    }//GEN-LAST:event_AddAccountActionPerformed
    
    private void showFormAddDialog() {
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Add Form", true);
        dialog.getContentPane().add(new FormAdd(dialog, this));
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    
    private void deleteAccount() {
        int selectedRow = tableListUser.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int userId = (int) tableListUser.getValueAt(selectedRow, 0);

        UserDAO userdao = new UserDAO();
        if (userdao.deleteAccount(userId)) {
            JOptionPane.showMessageDialog(this, "User status set to inactive.", "Success", JOptionPane.INFORMATION_MESSAGE);
            GetList();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to set user status to inactive.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void showFormEditDialog(UsersModel userModel) {
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Edit Form", true);
        dialog.getContentPane().add(new FormEdit(dialog, this, userModel));
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAccount;
    private javax.swing.JButton DeleteEmploy;
    private javax.swing.JButton editAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tableListUser;
    // End of variables declaration//GEN-END:variables
}
