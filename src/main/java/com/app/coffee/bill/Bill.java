/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.bill;

import com.app.coffee.Backend.DAO.OrderDetailDAO;
import com.app.coffee.Backend.DAO.UserDAO;
import com.app.coffee.Backend.Model.OrderModel;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Admin
 */
public class Bill extends javax.swing.JPanel {
    private double totalBillValue = 0.0;
    /**
     * Creates new form Bill
     */
    public Bill() {
        initComponents();
        setCellRenderer(tableBill);
       // setDefTable();
        populateComboBox();
        refreshListBill();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBill = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TotalBill = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        JcomboBoxUserName = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 114, 44)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1340, 720));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tableBill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Order", "Name", "Description", "Total", "Day", "Detail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBill.setRowHeight(30);
        tableBill.setShowGrid(true);
        jScrollPane1.setViewportView(tableBill);
        if (tableBill.getColumnModel().getColumnCount() > 0) {
            tableBill.getColumnModel().getColumn(0).setPreferredWidth(10);
            tableBill.getColumnModel().getColumn(3).setPreferredWidth(400);
            tableBill.getColumnModel().getColumn(5).setPreferredWidth(120);
            tableBill.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Total Bill:");

        TotalBill.setBackground(new java.awt.Color(255, 255, 255));
        TotalBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotalBill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1185, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalBill, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalBill, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("From :");

        jDateChooser1.setDate(new java.util.Date(1718996884000L));
        jDateChooser1.setDateFormatString(" yyyy , MMMMM d");
        jDateChooser1.setDoubleBuffered(false);
        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jDateChooser1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("To :");

        jDateChooser2.setDateFormatString(" yyyy , MMMMM d");
        jDateChooser2.setDoubleBuffered(false);

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.setPreferredSize(new java.awt.Dimension(100, 27));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ToDay");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 27));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbuttonDayNow(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 102, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Refresh");
        jButton3.setPreferredSize(new java.awt.Dimension(100, 25));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRefresh(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Bill Lable:");

        JcomboBoxUserName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        JcomboBoxUserName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JcomboBoxUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcomboBoxUserNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JcomboBoxUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JcomboBoxUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jButton2.getAccessibleContext().setAccessibleName("Refesh");

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1350, 733));

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setLayout(new java.awt.BorderLayout());
        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 1340, -1));

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(1350, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bill Manager");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1107, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void Search(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search
    Date fromDate = jDateChooser1.getDate();
    Date toDate = jDateChooser2.getDate();
    String selectedUserName = (String) JcomboBoxUserName.getSelectedItem();
    if (fromDate == null || toDate == null) {
        JOptionPane.showMessageDialog(this, "Please select both dates.", "Error!!", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (fromDate.after(toDate)) {
        JOptionPane.showMessageDialog(this, "The start date cannot be greater than the end date.", "Error!!!", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    LocalDateTime fromDateLocalDateTime = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    LocalDateTime toDateLocalDateTime = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    if ( "All".equals(selectedUserName)) {
        refreshListBillByDate(fromDateLocalDateTime, toDateLocalDateTime);
    } else {
        refreshListBillByUsernameAndDate(selectedUserName, fromDateLocalDateTime, toDateLocalDateTime);
    }
    
    }//GEN-LAST:event_Search
    
    private void JbuttonDayNow(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbuttonDayNow
        // TODO add your handling code herer
        refreshDayNow();      
    }//GEN-LAST:event_JbuttonDayNow

    private void ButtonRefresh(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRefresh
        // TODO add your handling code here:
        refreshListBill();
    }//GEN-LAST:event_ButtonRefresh

    private void JcomboBoxUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcomboBoxUserNameActionPerformed
                // TODO add your handling code here:
        String selectedUserName = (String) JcomboBoxUserName.getSelectedItem();   
        if (selectedUserName != null && !selectedUserName.isEmpty() && !"All".equals(selectedUserName)) {
            refreshListBillByUsername(selectedUserName);
        } else {
            refreshListBill();
        }        
    }//GEN-LAST:event_JcomboBoxUserNameActionPerformed
    
    private void populateComboBox() {
        JcomboBoxUserName.removeAllItems(); 
        JcomboBoxUserName.addItem("All");
        List<String> usernames = UserDAO.getUsernamesFromDatabase(); 
        for (String username : usernames) {
            JcomboBoxUserName.addItem(username);
        }
    }
   
    
    public void refreshDayNow() {
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    ArrayList<OrderModel> listBill = orderDetailDAO.selectAll1Bill();
    
    LocalDate today = LocalDate.now();
    String selectedUserName = (String) JcomboBoxUserName.getSelectedItem();
    
    DefaultTableModel defaultTableModel = (DefaultTableModel) tableBill.getModel();
    defaultTableModel.setRowCount(0);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd    HH:mm:ss");
    JButton button = new JButton("Detail");
    totalBillValue = 0.0;
    int index = 1;
    for (OrderModel order : listBill) {
        if (order.getDay().toLocalDate().isEqual(today)) {
            if ("All".equals(selectedUserName) || selectedUserName.equals(order.getUsername())) {
                Object[] row = {
                    index,
                    order.getOrder_id(),
                    order.getUsername(),
                    order.getDescription(),
                    order.getTotal(),
                    order.getDay().format(formatter),
                    button
                };
                defaultTableModel.addRow(row);
                totalBillValue += order.getTotal();
                index++;
            }
        }
    }

    tableBill.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
    tableBill.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));
    DecimalFormat df = new DecimalFormat("#.0");
    String formattedTotalBillValue = df.format(totalBillValue);
    
    TotalBill.setText(" " + formattedTotalBillValue);

}
    
    
    public void refreshListBill(){
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        ArrayList<OrderModel> ListBill = orderDetailDAO.selectAll1Bill();
        ListBill.sort((o1, o2) -> o2.getDay().compareTo(o1.getDay()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd    HH:mm:ss");
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableBill.getModel();
        defaultTableModel.setRowCount(0);
        totalBillValue = 0.0;
        int index = 1;
        JButton button = new JButton("Detail");
        for(OrderModel list: ListBill ){
            Object[] row = {
                index ,
                list.getOrder_id(),
                list.getUsername(),
                list.getDescription(),
                list.getTotal(),
                list.getDay().format(formatter),
                button
            };
            defaultTableModel.addRow(row);
            totalBillValue += list.getTotal() ;
            index++;
        }
        tableBill.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());

        tableBill.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JCheckBox()));
        DecimalFormat df = new DecimalFormat("#.0");
        String formattedTotalBillValue = df.format(totalBillValue);

        TotalBill.setText(" " + formattedTotalBillValue);

        
    }

     private void setCellRenderer(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
         JTableHeader header = tableBill.getTableHeader();
                if (header != null) {
                    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY)); 
                }
                
                setFont(new Font("Arial", Font.BOLD, 14)); 

      }
    public void refreshListBillByDate(LocalDateTime  fromDate, LocalDateTime  toDate) {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

        ArrayList<OrderModel> listBill = orderDetailDAO.selectByDateRange(fromDate, toDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd    HH:mm:ss");

        DefaultTableModel defaultTableModel = (DefaultTableModel) tableBill.getModel();
        defaultTableModel.setRowCount(0);
        totalBillValue = 0.0;
        int index = 1;
        for (OrderModel order : listBill) {
            Object[] row = {
                index,
                order.getOrder_id(),
                order.getUsername(),
                order.getDescription(),
                order.getTotal(),
                order.getDay().format(formatter)
            };
            defaultTableModel.addRow(row);
            totalBillValue += order.getTotal();
            index++;
        }
        DecimalFormat df = new DecimalFormat("#.0");
        String formattedTotalBillValue = df.format(totalBillValue);

        TotalBill.setText(" " + formattedTotalBillValue);

}
    public void refreshListBillByUsernameAndDate(String username, LocalDateTime  fromDate, LocalDateTime  toDate) {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

        ArrayList<OrderModel> listBill = orderDetailDAO.selectByUsernameAndDate(username,fromDate, toDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd    HH:mm:ss");

        DefaultTableModel defaultTableModel = (DefaultTableModel) tableBill.getModel();
        defaultTableModel.setRowCount(0);
        totalBillValue = 0.0;
        int index = 1;
        for (OrderModel order : listBill) {
            Object[] row = {
                index,
                order.getOrder_id(),
                order.getUsername(),
                order.getDescription(),
                order.getTotal(),
                order.getDay().format(formatter)
            };
            defaultTableModel.addRow(row);
            totalBillValue += order.getTotal();
            index++ ;
        }
        DecimalFormat df = new DecimalFormat("#.0");
        String formattedTotalBillValue = df.format(totalBillValue);

        TotalBill.setText(" " + formattedTotalBillValue);

        
}
    public void refreshListBillByUsername(String userName) {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

        ArrayList<OrderModel> listBill = orderDetailDAO.selectByUsername(userName);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd    HH:mm:ss");

        DefaultTableModel defaultTableModel = (DefaultTableModel) tableBill.getModel();
        defaultTableModel.setRowCount(0);
         if (listBill.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No order data for users: " + userName, "Announcement", JOptionPane.INFORMATION_MESSAGE);
    } else {
        totalBillValue = 0.0;
        int index = 1;
        for (OrderModel order : listBill) {
            Object[] row = {
                index,
                order.getOrder_id(),
                order.getUsername(),
                order.getDescription(),
                order.getTotal(),
                order.getDay().format(formatter)
            };
            defaultTableModel.addRow(row);
            totalBillValue += order.getTotal();
             index++ ;
        }       
        DecimalFormat df = new DecimalFormat("#.0");
        String formattedTotalBillValue = df.format(totalBillValue);

        TotalBill.setText(" " + formattedTotalBillValue);

         }
}   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcomboBoxUserName;
    private javax.swing.JLabel TotalBill;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBill;
    // End of variables declaration//GEN-END:variables

}
