/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.employee;

import com.app.coffee.Backend.DAO.UserDAO;
import com.app.coffee.Backend.Model.UsersModel;
import com.app.coffee.dashboard.Dashboard;
import com.app.coffee.design.TableGradient;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author phamv
 */
public class EmployeeManager extends javax.swing.JPanel {

    public EmployeeManager() {
        initComponents();
        setDefTable();
        
        GetList();
        
         DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer()
        {
            @Override
             public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                c.setForeground(Color.BLUE); // Đặt màu chữ của tiêu đề cột thành màu xanh
                Font font = c.getFont(); // Lấy font hiện tại
                font = font.deriveFont(Font.BOLD, 16f); // Đặt font là đậm, kích thước
                c.setFont(font);
                return c;
            }
        };        
        headerRenderer.setHorizontalAlignment(JLabel.CENTER); // Đặt căn cho tiêu đề
        // Lặp qua từng cột và đặt renderer cho tiêu đề cột
        JTableHeader productTable = tableListUser.getTableHeader();
       
        productTable.setDefaultRenderer(headerRenderer);
       

        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Đặt căn cho văn bản
        // Áp dụng cho ProductTable
        for (int i = 0; i < tableListUser.getColumnCount(); i++) {
            tableListUser.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
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
                user.getPhone() != null ? user.getPhone() : "",
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
        editAccount = new javax.swing.JButton();
        DeleteEmploy = new javax.swing.JButton();
        AddAccount = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        restoreAccount = new javax.swing.JButton();
        staffSchedule = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1350, 650));

        jPanel1.setLayout(new java.awt.BorderLayout());

        tableListUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        tableListUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Name", "Position", "Phone", "Email"
            }
        ));
        tableListUser.setRowHeight(30);
        tableListUser.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableListUser.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableListUser.setShowGrid(false);
        tableListUser.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tableListUser);
        if (tableListUser.getColumnModel().getColumnCount() > 0) {
            tableListUser.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableListUser.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableListUser.getColumnModel().getColumn(3).setPreferredWidth(150);
            tableListUser.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jPanel1.add(scroll, java.awt.BorderLayout.CENTER);

        editAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editAccount.setForeground(new java.awt.Color(255, 102, 0));
        editAccount.setText("Edit");
        editAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAccountActionPerformed(evt);
            }
        });

        DeleteEmploy.setBackground(new java.awt.Color(51, 51, 51));
        DeleteEmploy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteEmploy.setForeground(new java.awt.Color(255, 255, 255));
        DeleteEmploy.setText("Delete");
        DeleteEmploy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmployActionPerformed(evt);
            }
        });

        AddAccount.setBackground(new java.awt.Color(255, 153, 0));
        AddAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddAccount.setForeground(new java.awt.Color(255, 255, 255));
        AddAccount.setText("Add");
        AddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAccountActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Employee Management");

        restoreAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        restoreAccount.setForeground(new java.awt.Color(255, 102, 0));
        restoreAccount.setText("Restore Account");
        restoreAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreAccountActionPerformed(evt);
            }
        });

        staffSchedule.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        staffSchedule.setForeground(new java.awt.Color(255, 102, 0));
        staffSchedule.setText("Staff Schedule");
        staffSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffScheduleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(restoreAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staffSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restoreAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 755, Short.MAX_VALUE)
                        .addComponent(AddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteEmploy, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteEmploy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addGap(39, 39, 39))
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

    private void restoreAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreAccountActionPerformed
        showReturnAccountPanel();
    }//GEN-LAST:event_restoreAccountActionPerformed

    private void staffScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffScheduleActionPerformed
        showStaffSchedulePanel();
    }//GEN-LAST:event_staffScheduleActionPerformed
    
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
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this account?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response != JOptionPane.YES_OPTION) {
            return;
        }

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
    
    private void showReturnAccountPanel() {
         Container parent = this.getParent();
        while (parent != null && !(parent instanceof Dashboard)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            Dashboard dashboard = (Dashboard) parent;
            dashboard.showPanel("returnAccount");
        }   
    }
    
    private void showStaffSchedulePanel() {
        Container parent = this.getParent();
        while (parent != null && !(parent instanceof Dashboard)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            Dashboard dashboard = (Dashboard) parent;
            dashboard.showPanel("staffSchedule");
        }   
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAccount;
    private javax.swing.JButton DeleteEmploy;
    private javax.swing.JButton editAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton restoreAccount;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JButton staffSchedule;
    private javax.swing.JTable tableListUser;
    // End of variables declaration//GEN-END:variables
}
