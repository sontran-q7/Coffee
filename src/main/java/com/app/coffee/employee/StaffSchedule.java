/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.employee;

import com.app.coffee.Backend.Model.ControlModel;
import com.app.coffee.Backend.Service.ControlService;
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
import java.util.Date;
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
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date selectedDate = jDateChooser.getDate();
                if (selectedDate != null) {
                    LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    filterByDate(localDate);
                }
            }
        });
        SearchToday.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByDate(LocalDate.now());
            }
        });
        
        Show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               GetList();
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

        for (ControlModel control : controlList) {
            model.addRow(new Object[]{
                control.getWorkingTime().getName(),
                control.getAccount().getUserName(), 
                control.getCheckIn().format(timeFormatter), 
                control.getCheckOut().format(timeFormatter), 
                control.getCheckInPay(),
                control.getCheckOutPay(),
                control.getCreatedAt().format(dateFormatter)
            });
        }
    }

    private void filterByDate(LocalDate date) {
        List<ControlModel> controlList = controlService.getControlsByDate(date.atStartOfDay()); // Ideally, you should have a method to get controls by date
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 

        for (ControlModel control : controlList) {
            if (control.getCreatedAt().toLocalDate().equals(date)) {
                model.addRow(new Object[]{
                    control.getWorkingTime().getName(),
                    control.getAccount().getUserName(),
                    control.getCheckIn().format(timeFormatter), 
                    control.getCheckOut().format(timeFormatter), 
                    control.getCheckInPay(),
                    control.getCheckOutPay(),
                    control.getCreatedAt().format(dateFormatter) 
                });
            }
        }
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

        jDateChooser = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Search = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BackManager = new javax.swing.JButton();
        Show = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        SearchToday = new javax.swing.JButton();

        jPanel1.setLayout(new java.awt.BorderLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Shift", "Name", "Arrival time", "Time to leave", "First money", "End money", "Date"
            }
        ));
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jPanel1.add(scroll, java.awt.BorderLayout.CENTER);

        Search.setBackground(new java.awt.Color(255, 102, 0));
        Search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search");

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Staff Schedule");

        BackManager.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackManager.setForeground(new java.awt.Color(255, 102, 0));
        BackManager.setText("Back Manager");
        BackManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackManagerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addComponent(BackManager, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(BackManager, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        Show.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Show.setForeground(new java.awt.Color(255, 102, 0));
        Show.setText(" Show all");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Staff Table:");

        SearchToday.setBackground(new java.awt.Color(255, 102, 0));
        SearchToday.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SearchToday.setForeground(new java.awt.Color(255, 255, 255));
        SearchToday.setText("Today");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchToday, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Show, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                .addGap(41, 41, 41))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(Show, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(SearchToday, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 566, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackManagerActionPerformed
        backEmployeePanel();
    }//GEN-LAST:event_BackManagerActionPerformed
    
    
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
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
