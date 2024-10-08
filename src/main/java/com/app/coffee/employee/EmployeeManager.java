/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.employee;

import com.app.coffee.Backend.DAO.UserDAO;
import com.app.coffee.Backend.Model.UsersModel;
import com.app.coffee.category.CustomHeaderRenderer;
import com.app.coffee.dashboard.Dashboard;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
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
    //setDefTable();
    loadPanels();
    SetColumn();
    GetList();
     
    JTableHeader header = tableListUser.getTableHeader();
    header.setDefaultRenderer(new CustomHeaderRenderer());
        
}
    private void SetColumn() {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer()
        {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
             
            return c;
        }
    };
    headerRenderer.setHorizontalAlignment(JLabel.CENTER); 
    JTableHeader productTable = tableListUser.getTableHeader();
       
    productTable.setDefaultRenderer(headerRenderer);

    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); 
        
    for (int i = 0; i < tableListUser.getColumnCount(); i++) {
        if (i != 1) {
            tableListUser.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }    
    tableListUser.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderTest()); 
    }
    
    public void refresh(){
        GetList();
    }
    
    public void GetList() {
    UserDAO userdao = new UserDAO();    
    ArrayList<UsersModel> listUser = userdao.selectAll();

    Collections.sort(listUser, new Comparator<UsersModel>() {
        @Override
        public int compare(UsersModel u1, UsersModel u2) {
            return u1.getAccount_id() - u2.getAccount_id();
        }
    });

    DefaultTableModel table = (DefaultTableModel) tableListUser.getModel();
    table.setRowCount(0);
    int count=1;

    for (UsersModel user : listUser) {
        if (user.getStatus() == 1 && user.getRole().getRole_id() != 1) {
            Object[] row = {
                count++,
                user.getImage() != null ? user.getImage() : "no-image.png",
                user.getUserName() != null ? user.getUserName() : "",
                user.getRole() != null ? user.getRole().getName() : "", 
                user.getPhone() != null ? user.getPhone() : "",
                user.getEmail() != null ? user.getEmail() : ""     
            };
            table.addRow(row);
        }
    }
    // image
    tableListUser.setRowHeight(60);
    tableListUser.getColumnModel().getColumn(1).setCellRenderer(new ImageRenderTest());
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
        FormEmployee = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        restoreAccount = new javax.swing.JButton();
        staffSchedule = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1350, 650));

        jPanel1.setLayout(new java.awt.BorderLayout());

        tableListUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "Image", "Name", "Position", "Phone", "Email"
            }
        ));
        tableListUser.setRowHeight(30);
        tableListUser.setShowGrid(true);
        tableListUser.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tableListUser);
        if (tableListUser.getColumnModel().getColumnCount() > 0) {
            tableListUser.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel1.add(scroll, java.awt.BorderLayout.CENTER);

        editAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editAccount.setForeground(new java.awt.Color(255, 102, 0));
        editAccount.setText("Edit");
        editAccount.setPreferredSize(new java.awt.Dimension(90, 30));
        editAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAccountActionPerformed(evt);
            }
        });

        DeleteEmploy.setBackground(new java.awt.Color(51, 51, 51));
        DeleteEmploy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteEmploy.setForeground(new java.awt.Color(255, 255, 255));
        DeleteEmploy.setText("Delete");
        DeleteEmploy.setPreferredSize(new java.awt.Dimension(90, 30));
        DeleteEmploy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteEmployActionPerformed(evt);
            }
        });

        AddAccount.setBackground(new java.awt.Color(255, 102, 0));
        AddAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddAccount.setForeground(new java.awt.Color(255, 255, 255));
        AddAccount.setText("Add");
        AddAccount.setPreferredSize(new java.awt.Dimension(90, 30));
        AddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAccountActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Employee Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(1047, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );

        FormEmployee.setBackground(new java.awt.Color(255, 255, 255));
        FormEmployee.setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Employee Table:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Employee Form:");

        restoreAccount.setBackground(new java.awt.Color(255, 102, 0));
        restoreAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        restoreAccount.setForeground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(restoreAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(staffSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteEmploy, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeleteEmploy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(staffSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(restoreAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(FormEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAccountActionPerformed
       int selectedRow = tableListUser.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String email = (String) tableListUser.getValueAt(selectedRow, 5); 
        UserDAO userdao = new UserDAO();
        UsersModel userModel = userdao.selectByEmail(email);

        if (userModel != null) {
            FormEdit formEdit = new FormEdit(null, this, userModel);
            FormEmployee.add(formEdit, "formEdit");
            showPanel("formEdit");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to retrieve user details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editAccountActionPerformed

    private void DeleteEmployActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteEmployActionPerformed
        deleteAccount();
    }//GEN-LAST:event_DeleteEmployActionPerformed

    private void AddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAccountActionPerformed
        showPanel("formAdd");
    }//GEN-LAST:event_AddAccountActionPerformed

    private void restoreAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreAccountActionPerformed
        showReturnAccountPanel();
    }//GEN-LAST:event_restoreAccountActionPerformed

    private void staffScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffScheduleActionPerformed
        showStaffSchedulePanel();
    }//GEN-LAST:event_staffScheduleActionPerformed
    
    
    private void deleteAccount() {
        int selectedRow = tableListUser.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String email = (String) tableListUser.getValueAt(selectedRow, 5); 
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this account?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response != JOptionPane.YES_OPTION) {
            return;
        }

        UserDAO userdao = new UserDAO();
        int result = userdao.DeleteByStatus(email);
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Account delete success.", "Success", JOptionPane.INFORMATION_MESSAGE);
            GetList();
        } else {
            JOptionPane.showMessageDialog(this, "Account delete failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
    
    // demo
    private void loadPanels() {
        FormAdd formAdd = new FormAdd(null, this);
        FormEmployee.add(formAdd, "formAdd");
    }

    private void showPanel(String panelName) {
       
        ((CardLayout) FormEmployee.getLayout()).show(FormEmployee, panelName);
    }

    private class ImageRenderTest extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String photoName = value != null ? value.toString() : "no-image.png";
            File imageFile = new File("src/image/" + photoName);
            if (!imageFile.exists()) {
                imageFile = new File("src/image/no-image.png");
            }
            ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(imageFile.getAbsolutePath()).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));          
            return new JLabel(imageIcon);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAccount;
    private javax.swing.JButton DeleteEmploy;
    private javax.swing.JPanel FormEmployee;
    private javax.swing.JButton editAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton restoreAccount;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JButton staffSchedule;
    private javax.swing.JTable tableListUser;
    // End of variables declaration//GEN-END:variables
}
