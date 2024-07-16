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
        
        GetList();
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
                if (startDate != null && endDate != null) {
                    LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate localEndDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    filterByDateRange(localStartDate, localEndDate);
                }
            }
        });
        
        SearchToday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByDate(LocalDate.now());
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
        // Lặp qua từng cột và đặt renderer cho tiêu đề cột
    JTableHeader productTable = table.getTableHeader();
       
    productTable.setDefaultRenderer(headerRenderer);


        
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Đặt căn cho văn bản
        
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }
    }
    
    public void refresh(){
        GetList();
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
    
    private void filterByCurrentMonth() {
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        filterByDateRange(firstDayOfMonth, lastDayOfMonth);
    }
    
    private void filterByDateAndName(LocalDate date, String name) {
        List<ControlModel> controlList = controlService.getControlsByDate(date.atStartOfDay());
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int count = 1;

        for (ControlModel control : controlList) {
            if (control.getCreatedAt().toLocalDate().equals(date) && 
                (name == null || control.getAccount().getUserName().equals(name))) {
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

        countTotal.setText(String.valueOf(total));
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

        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        BackManager = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        SearchToday = new javax.swing.JButton();
        ShowMonth = new javax.swing.JButton();
        Show = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        countTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.BorderLayout());

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

        jPanel1.add(scroll, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Staff Schedule");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addContainerGap(1345, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Staff Table:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BackManager.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackManager.setForeground(new java.awt.Color(255, 102, 0));
        BackManager.setText("Back Manager");
        BackManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackManagerActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("To :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("From :");

        Search.setBackground(new java.awt.Color(255, 102, 0));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search");

        SearchToday.setBackground(new java.awt.Color(255, 102, 0));
        SearchToday.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SearchToday.setForeground(new java.awt.Color(255, 255, 255));
        SearchToday.setText("Today");

        ShowMonth.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ShowMonth.setForeground(new java.awt.Color(255, 102, 0));
        ShowMonth.setText("Month");
        ShowMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowMonthActionPerformed(evt);
            }
        });

        Show.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Show.setForeground(new java.awt.Color(255, 102, 0));
        Show.setText(" Show all");
        Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Total:");

        countTotal.setEditable(false);
        countTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(SearchToday, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShowMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Show, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchToday, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Show, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Staff Form:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackManager, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(304, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackManager, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 720, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackManagerActionPerformed
        backEmployeePanel();
    }//GEN-LAST:event_BackManagerActionPerformed

    private void ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowActionPerformed
        GetList();
    }//GEN-LAST:event_ShowActionPerformed

    private void ShowMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowMonthActionPerformed
        filterByCurrentMonth();
    }//GEN-LAST:event_ShowMonthActionPerformed

    private void countTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countTotalActionPerformed
    
    
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
    private javax.swing.JTextField countTotal;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
