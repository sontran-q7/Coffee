/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.dashboard;

import com.app.coffee.Backend.DAO.BillDAO;

import com.app.coffee.Backend.Model.PendingBill;
import com.app.coffee.Login.LoginAccount.UserSession;
import com.app.coffee.bill.ButtonEditor;
import com.app.coffee.bill.ButtonRenderer;
import com.app.coffee.employee.FormAdd;
import java.awt.Button;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DashboardPage extends javax.swing.JPanel {
    public String userName;
    private int controlId;
    /**
     * Creates new form DashboardPage
     */
    public DashboardPage() {
        initComponents();
        
        userName = UserSession.getInstance().getUserName();
        setCellRenderer(PendingBillTabel1);
        updatePendingBillTable();
        displayTotalSumOfMonth();
        displayTotalSumOfDay();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Money_day = new javax.swing.JLabel();
        MonthPanel = new javax.swing.JLabel();
        Money_Month = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PendingBill = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        finishBill = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        AddStaff = new javax.swing.JButton();
        EndShift = new javax.swing.JButton();
        StaffPanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        PositionCard = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        PositionCard9 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        PositionCard10 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        PositionCard11 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        PositionCard12 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1350, 740));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Daily sales revenue :");

        Money_day.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Money_day.setForeground(new java.awt.Color(51, 51, 51));
        Money_day.setText("USD");

        MonthPanel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        MonthPanel.setForeground(new java.awt.Color(255, 255, 255));
        MonthPanel.setText("Monthly revenue");

        Money_Month.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Money_Month.setForeground(new java.awt.Color(51, 51, 51));
        Money_Month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Money_Month.setText("USD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(Money_day, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(MonthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Money_Month, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Money_day, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Money_Month, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MonthPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 80));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        PendingBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Total", "Description", "Table number", "Day", "Status", "Detail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        PendingBill.setRowHeight(30);
        jScrollPane1.setViewportView(PendingBill);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 1190, 290));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pending Bill");

        finishBill.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        finishBill.setForeground(new java.awt.Color(255, 102, 0));
        finishBill.setText("Finish");
        finishBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(489, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(372, 372, 372)
                .addComponent(finishBill, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(finishBill, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 1190, -1));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Shift Manager");

        AddStaff.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddStaff.setForeground(new java.awt.Color(255, 102, 0));
        AddStaff.setText("Add");
        AddStaff.setPreferredSize(new java.awt.Dimension(90, 30));
        AddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStaffActionPerformed(evt);
            }
        });

        EndShift.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EndShift.setText("Edit");
        EndShift.setPreferredSize(new java.awt.Dimension(90, 30));
        EndShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndShiftActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239)
                .addComponent(AddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(EndShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(AddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndShift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 1190, -1));

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel15.setPreferredSize(new java.awt.Dimension(143, 186));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PositionCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel15.add(PositionCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 131, 91, 56));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Image");
        jLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, 110, 70));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Name");
        jPanel15.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 50, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TRAN ANH SON");
        jPanel15.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Position");
        jPanel15.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 130, 70, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Manager");
        jPanel15.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, -1));

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel16.setPreferredSize(new java.awt.Dimension(143, 186));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PositionCard9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel16.add(PositionCard9, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 131, 91, 56));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Image");
        jLabel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, 110, 70));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Name");
        jPanel16.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 50, -1));

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("TRAN ANH SON");
        jPanel16.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Position");
        jPanel16.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 130, 70, -1));

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Manager");
        jPanel16.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, -1));

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel17.setPreferredSize(new java.awt.Dimension(143, 186));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PositionCard10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel17.add(PositionCard10, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 131, 91, 56));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Image");
        jLabel57.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, 110, 70));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Name");
        jPanel17.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 50, -1));

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("TRAN ANH SON");
        jPanel17.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Position");
        jPanel17.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 130, 70, -1));

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Manager");
        jPanel17.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel18.setPreferredSize(new java.awt.Dimension(143, 186));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PositionCard11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel18.add(PositionCard11, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 131, 91, 56));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("Image");
        jLabel62.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel18.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, 110, 70));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Name");
        jPanel18.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 50, -1));

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("TRAN ANH SON");
        jPanel18.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Position");
        jPanel18.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 130, 70, -1));

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Manager");
        jPanel18.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, -1));

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel19.setPreferredSize(new java.awt.Dimension(143, 186));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PositionCard12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel19.add(PositionCard12, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 131, 91, 56));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Image");
        jLabel67.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, 110, 70));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Name");
        jPanel19.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 50, -1));

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("TRAN ANH SON");
        jPanel19.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 120, -1));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Position");
        jPanel19.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 130, 70, -1));

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Manager");
        jPanel19.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, -1));

        javax.swing.GroupLayout StaffPanelLayout = new javax.swing.GroupLayout(StaffPanel);
        StaffPanel.setLayout(StaffPanelLayout);
        StaffPanelLayout.setHorizontalGroup(
            StaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        StaffPanelLayout.setVerticalGroup(
            StaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(StaffPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 1190, 210));
    }// </editor-fold>//GEN-END:initComponents

    private void AddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStaffActionPerformed
          UserSession session = UserSession.getInstance();
    int controlId = session.getControlId();
    
    // Kiểm tra xem có ca làm việc nào đang hoạt động không
    if (controlId != 0 && !session.isShiftEnded()) {
        JOptionPane.showMessageDialog(this, "Bạn không thể tạo ca mới khi chưa chốt ca hiện tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            AddShift dialog = new AddShift(new javax.swing.JFrame(), true);
            dialog.setUserName(userName);
            
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    dialog.setVisible(false);
                    dialog.dispose();
                }
            });
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    });
    }//GEN-LAST:event_AddStaffActionPerformed

    private void EndShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndShiftActionPerformed
      UserSession session = UserSession.getInstance();
    int controlId = session.getControlId();
        System.out.println("control :" + controlId);
        // lỗi vì để == -1
    if (controlId == 0) {
        JOptionPane.showMessageDialog(this, "Không có ca làm việc nào để chốt.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Lấy tham chiếu tới JFrame chứa JPanel này
    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
    EndShift dialog = new EndShift(parentFrame, true, controlId);
    
    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            dialog.setVisible(false);
            dialog.dispose();
        }
    });

    dialog.setLocationRelativeTo(parentFrame); // Hiển thị dialog ở giữa cửa sổ hiện tại
    dialog.setVisible(true);
    }//GEN-LAST:event_EndShiftActionPerformed

    private void finishBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishBillActionPerformed
        DefaultTableModel model = (DefaultTableModel) PendingBill.getModel();
    for (int i = model.getRowCount() - 1; i >= 0; i--) {
        Boolean status = (Boolean) model.getValueAt(i, 5); 
        if (status != null && status) {
            int orderId = getOrderIDFromSerialNo(i + 1); 
            BillDAO.markBillAsFinished(orderId);
            model.removeRow(i);
            updateTableSTT();
        }
    }
    }//GEN-LAST:event_finishBillActionPerformed
 
    // chỉnh form detail
    private void showDetailDialog() {
    JDialog detailDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Detail Dialog", true);

    int centerX = this.getWidth() / 2 - detailDialog.getWidth() / 6;
    int centerY = this.getHeight() / 2 - detailDialog.getHeight() / 6;
    
    // Set the dialog location
    detailDialog.setLocation(centerX, centerY);  
    // Show the dialog
    detailDialog.setVisible(true);
    detailDialog.setLocationRelativeTo(null);
}
    
    public void refresh(){
        updatePendingBillTable();
        displayTotalSumOfDay();
        displayTotalSumOfMonth();
   }
    

     private void updatePendingBillTable() {
    List<PendingBill> pendingBills = BillDAO.getPendingBills();
    DefaultTableModel model = (DefaultTableModel) PendingBill.getModel();
    model.setRowCount(0); // Clear the table before adding new rows

    JButton detailButton = new JButton("Detail");
    detailButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            showDetailDialog(); // Call the method to show dialog on button click
        }
    });

    int serialNo = 1;
    for (PendingBill bill : pendingBills) {
        Object[] row = new Object[]{
            serialNo++, // Add serial number instead of order_id
            bill.getTotal(),
            bill.getDescription(),
            bill.getTable_number(),
            bill.getDay(),
            bill.isStatus(),
            detailButton
        };
        model.addRow(row);
        updateTableSTT();
    }

    PendingBill.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
    PendingBill.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));
}

     private void updateTableSTT() {
        DefaultTableModel model = (DefaultTableModel) PendingBill.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); // Cập nhật lại STT
        }
        PendingBillTabel1.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());

        PendingBillTabel1.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));   
    }
     private void displayTotalSumOfMonth() {
    float totalSum = BillDAO.getTotalSumOfMonth(); 
    DecimalFormat df = new DecimalFormat("#,##0.00"+" USD");
    String formattedTotalSum = df.format(totalSum);
    if (Money_Month != null) {
        Money_Month.setText(formattedTotalSum); 
    } else {
        System.out.println("Money_Month JLabel is null");
    }
}
     
      private void displayTotalSumOfDay() {
        float totalSum = BillDAO.getTotalSumOfDay(); 
        // Format số để hiển thị
        DecimalFormat df = new DecimalFormat("#,##0.00" + " USD");
        String formattedTotalSum = df.format(totalSum);
        Money_day.setText(formattedTotalSum);
    }
      
      private void setCellRenderer(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

         for (int i = 0; i < table.getColumnCount(); i++) {
        // trừ ô status vì có checkboxx
        if (i != table.getColumn("Status").getModelIndex()) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
      }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddStaff;
    private javax.swing.JButton EndShift;
    private javax.swing.JLabel Money_Month;
    private javax.swing.JLabel Money_day;
    private javax.swing.JLabel MonthPanel;
    private javax.swing.JTable PendingBill;
    private javax.swing.JLabel PositionCard;
    private javax.swing.JLabel PositionCard10;
    private javax.swing.JLabel PositionCard11;
    private javax.swing.JLabel PositionCard12;
    private javax.swing.JLabel PositionCard9;
    private javax.swing.JPanel StaffPanel;
    private javax.swing.JButton finishBill;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
