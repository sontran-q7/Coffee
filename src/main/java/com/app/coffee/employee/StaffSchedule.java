/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.employee;

import com.app.coffee.Backend.Model.ControlModel;
import com.app.coffee.Backend.Service.ControlService;
import com.app.coffee.category.CustomHeaderRenderer;
import com.app.coffee.dashboard.Dashboard;
import com.app.coffee.design.TableGradient;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author phamv
 */
public class StaffSchedule extends javax.swing.JPanel {
    
    private ControlService controlService;
    private DateTimeFormatter timeFormatter;
    private DateTimeFormatter dateFormatter;
      
    public StaffSchedule() {
        initComponents();
        //setDefTable();  
        controlService = new ControlService();
        timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        filterByDate(LocalDate.now());
        SetColumn();
        
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
        
        setupEventListeners();
    }
    
    private void setupEventListeners() {
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date startDate = jDateChooser1.getDate();
                Date endDate = jDateChooser.getDate();
                String selectedName = (String) jComboBox1.getSelectedItem();
                if (startDate != null && endDate != null) {
                    LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate localEndDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    filterByDateRangeAndName(localStartDate, localEndDate, selectedName);
                }
            }
            });
        
        SearchToday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) jComboBox1.getSelectedItem();
                if ("All".equals(selectedName)) {
                    filterByDateAndName(LocalDate.now(), "All");
                } else {
                    filterByDateAndName(LocalDate.now(), selectedName);
                }
            }
        });
        
        
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) jComboBox1.getSelectedItem();
                filterByName(selectedName);
            }
        });
    }
    
    private void SetColumn() {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer()
        {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Font font = c.getFont(); // Lấy font hiện tại
            c.setFont(font);
            return c;
        }
    };
    headerRenderer.setHorizontalAlignment(JLabel.CENTER); // Đặt căn cho tiêu đề
    JTableHeader productTable = table.getTableHeader();
       
    productTable.setDefaultRenderer(headerRenderer);

    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Đặt căn cho văn bản
        
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
    }
    
    public void refresh(){
        filterByDate(LocalDate.now());
    }
    
    public void GetList() {
        List<ControlModel> controlList = controlService.getAllControls();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 
        int count = 1;

        for (ControlModel control : controlList) {
            double totalDifference = control.getCheckOutPay() - control.getCheckInPay();
            model.addRow(new Object[]{
                count++,
                control.getWorkingTime().getName(),
                control.getAccount().getUserName(), 
                control.getCheckIn().format(timeFormatter), 
                control.getCheckOut().format(timeFormatter), 
                control.getCheckInPay(),
                control.getCheckOutPay(),              
                totalDifference,
                control.getCreatedAt().format(dateFormatter)
            });
        }
        
        updateFindNameComboBox(controlList);
        updateTotal();
    }

    private void filterByDate(LocalDate date) {
        List<ControlModel> controlList = controlService.getControlsByDate(date.atStartOfDay()); // Ideally, you should have a method to get controls by date
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 
        int count = 1;

        for (ControlModel control : controlList) {
            if (control.getCreatedAt().toLocalDate().equals(date)) {
                double totalDifference = control.getCheckOutPay() - control.getCheckInPay();
                model.addRow(new Object[]{
                    count++,
                    control.getWorkingTime().getName(),
                    control.getAccount().getUserName(),
                    control.getCheckIn().format(timeFormatter), 
                    control.getCheckOut().format(timeFormatter), 
                    control.getCheckInPay(),
                    control.getCheckOutPay(),
                    totalDifference,
                    control.getCreatedAt().format(dateFormatter)
                });
            }
        }
        updateFindNameComboBox(controlService.getAllControls());
        updateTotal();
    }
    
    private void filterByDateRange(LocalDate startDate, LocalDate endDate) {
        List<ControlModel> controlList = controlService.getAllControls();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int count = 1;

        for (ControlModel control : controlList) {
            LocalDate createdAt = control.getCreatedAt().toLocalDate();
            if ((createdAt.isEqual(startDate) || createdAt.isAfter(startDate)) &&
                (createdAt.isEqual(endDate) || createdAt.isBefore(endDate))) {
                double totalDifference = control.getCheckOutPay() - control.getCheckInPay();
                model.addRow(new Object[]{
                    count++,
                    control.getWorkingTime().getName(),
                    control.getAccount().getUserName(),
                    control.getCheckIn().format(timeFormatter),
                    control.getCheckOut().format(timeFormatter),
                    control.getCheckInPay(),
                    control.getCheckOutPay(),
                    totalDifference,
                    control.getCreatedAt().format(dateFormatter)
                });
            }
        }
        updateTotal();
    }
    
    private void filterByDateRangeAndName(LocalDate startDate, LocalDate endDate, String name) {
        List<ControlModel> controlList = controlService.getControlsByDateRange(startDate, endDate);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int count = 1;

        for (ControlModel control : controlList) {
            LocalDate createdAt = control.getCreatedAt().toLocalDate();
            if ((createdAt.isEqual(startDate) || createdAt.isAfter(startDate)) &&
                (createdAt.isEqual(endDate) || createdAt.isBefore(endDate)) &&
                ("All".equals(name) || control.getAccount().getUserName().equals(name))) {
                double totalDifference = control.getCheckOutPay() - control.getCheckInPay();
                model.addRow(new Object[]{
                    count++,
                    control.getWorkingTime().getName(),
                    control.getAccount().getUserName(),
                    control.getCheckIn().toLocalTime().format(timeFormatter),
                    control.getCheckOut().toLocalTime().format(timeFormatter),
                    control.getCheckInPay(),
                    control.getCheckOutPay(),
                    totalDifference,
                    control.getCreatedAt().format(dateFormatter)
                });
            }
        }
        updateTotal();
    }

    
    private void filterByCurrentMonth() {
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        filterByDateRangeAndName(firstDayOfMonth, lastDayOfMonth, "All");
    }

    private void filterByCurrentMonthAndName(String name) {
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        filterByDateRangeAndName(firstDayOfMonth, lastDayOfMonth, name);
    }
    
    private void filterByDateAndName(LocalDate date, String name) {
        List<ControlModel> controlList = controlService.getControlsByDate(date.atStartOfDay());
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int count = 1;

        for (ControlModel control : controlList) {
            if (control.getCreatedAt().toLocalDate().equals(date) &&
                    ("All".equals(name) || control.getAccount().getUserName().equals(name))) {
                double totalDifference = control.getCheckOutPay() - control.getCheckInPay();
                model.addRow(new Object[]{
                        count++,
                        control.getWorkingTime().getName(),
                        control.getAccount().getUserName(),
                        control.getCheckIn().format(timeFormatter),
                        control.getCheckOut().format(timeFormatter),
                        control.getCheckInPay(),
                        control.getCheckOutPay(),
                        totalDifference,
                        control.getCreatedAt().format(dateFormatter)
                });
            }
        }
        updateTotal();
    }
    
    private void filterByName(String name) {
        List<ControlModel> controlList = controlService.getAllControls();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int count = 1;

        for (ControlModel control : controlList) {
            if ("All".equals(name) || control.getAccount().getUserName().equals(name)) {
                double totalDifference = control.getCheckOutPay() - control.getCheckInPay();
                model.addRow(new Object[]{
                    count++,
                    control.getWorkingTime().getName(),
                    control.getAccount().getUserName(),
                    control.getCheckIn().format(timeFormatter),
                    control.getCheckOut().format(timeFormatter),
                    control.getCheckInPay(),
                    control.getCheckOutPay(),
                    totalDifference,
                    control.getCreatedAt().format(dateFormatter)
                });
            }
        }
        updateTotal();
    }
    
    
    
    private void updateFindNameComboBox(List<ControlModel> controlList) {
    jComboBox1.removeAllItems();
    jComboBox1.addItem("All");
    Set<String> addedEmails = new HashSet<>();
    for (ControlModel control : controlList) {
        String userEmail = control.getAccount().getUserName();
        if (!addedEmails.contains(userEmail)) {
            jComboBox1.addItem(userEmail);
            addedEmails.add(userEmail);
        }
    }
    
}
    
    private void updateTotal() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        double total = 0.0;   
        int totalColumnIndex = 7;
        for (int row = 0; row < model.getRowCount(); row++) {
            Double value = (Double) model.getValueAt(row, totalColumnIndex);
            total += value;
        }

        //countTotal.setText(String.valueOf(total));
    }

    private void setDefTable() {
        table.setDefaultRenderer(Object.class, new TableGradient(new Color(23,161,115),new Color(132,22,232)));
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        scroll.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        BackManager = new javax.swing.JButton();
        SearchToday = new javax.swing.JButton();
        ShowMonth = new javax.swing.JButton();
        Show = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1350, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lock Schedule");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addContainerGap(1151, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Lock Table:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 140, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 124, 30));

        BackManager.setBackground(new java.awt.Color(51, 51, 51));
        BackManager.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BackManager.setForeground(new java.awt.Color(255, 255, 255));
        BackManager.setText("Back Manager");
        BackManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackManagerActionPerformed(evt);
            }
        });
        add(BackManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 120, 130, 30));

        SearchToday.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SearchToday.setForeground(new java.awt.Color(255, 102, 0));
        SearchToday.setText("Today");
        add(SearchToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 110, 33));

        ShowMonth.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ShowMonth.setForeground(new java.awt.Color(255, 102, 0));
        ShowMonth.setText("Month");
        ShowMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowMonthActionPerformed(evt);
            }
        });
        add(ShowMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 120, 32));

        Show.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Show.setForeground(new java.awt.Color(255, 102, 0));
        Show.setText(" Show all");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });
        add(Show, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 120, 110, 32));
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 120, 31));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("From :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 57, 30));
        add(jDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 120, 31));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("To :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 57, 31));

        Search.setBackground(new java.awt.Color(255, 102, 0));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search");
        add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 90, 31));

        jPanel3.setLayout(new java.awt.BorderLayout());
        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 211, 1254, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Shift", "Name", "Arrival time", "Time to leave", "First money", "End money", "Total", "Date"
            }
        ));
        table.setRowHeight(30);
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 1260, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void BackManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackManagerActionPerformed
        backEmployeePanel();
    }//GEN-LAST:event_BackManagerActionPerformed

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        GetList();
    }//GEN-LAST:event_ShowActionPerformed

    private void ShowMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowMonthActionPerformed
        String selectedName = (String) jComboBox1.getSelectedItem();
        System.out.println("Selected name: " + selectedName); // Debugging line
        filterByCurrentMonthAndName(selectedName);
    }//GEN-LAST:event_ShowMonthActionPerformed
    
    
    private void backEmployeePanel() {
        Container parent = this.getParent();
        while (parent != null && !(parent instanceof Dashboard)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            Dashboard dashboard = (Dashboard) parent;
            dashboard.showPanel("employee");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackManager;
    private javax.swing.JButton Search;
    private javax.swing.JButton SearchToday;
    private javax.swing.JButton Show;
    private javax.swing.JButton ShowMonth;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
