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
//import com.app.coffee.employee.FormAdd;
//import java.awt.Button;
import java.awt.FlowLayout;
//import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
//import javax.swing.event.TableModelEvent;
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
        setCellRenderer(PendingBill);
        updatePendingBillTable();
        displayTotalSumOfMonth();
        displayTotalSumOfDay();
        
         PanelShift.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    }
    
     public void updateStaffPanel(ArrayList<String[]> selectedData) {
    PanelShift.removeAll(); // Xóa tất cả các thẻ cũ trong StaffPanel

    for (String[] rowData : selectedData) {
        JPanel card = new JPanel();
        card.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        card.setPreferredSize(new java.awt.Dimension(143, 210)); // Tăng chiều cao của card để chứa thêm thông tin
        card.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setIcon(new ImageIcon("src/image/" + rowData[1]));
        card.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 10, 110, 70));

        JLabel nameLabelHeader = new JLabel("Name");
        nameLabelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabelHeader.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12)); // Set font to Bold, size 12
        card.add(nameLabelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 20));

        JLabel nameLabel = new JLabel(rowData[2]);
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 20));

        JLabel positionLabelHeader = new JLabel("Position");
        positionLabelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        positionLabelHeader.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12)); // Set font to Bold, size 12
        card.add(positionLabelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, 20));

        JLabel positionLabel = new JLabel(rowData[3]);
        positionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card.add(positionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 20));

        JLabel phoneLabelHeader = new JLabel("Phone");
        phoneLabelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneLabelHeader.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12)); // Set font to Bold, size 12
        card.add(phoneLabelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 20));

        JLabel phoneLabel = new JLabel(rowData[4]);
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, 20));

        PanelShift.add(card);
    }

    PanelShift.revalidate();
    PanelShift.repaint();
}

     public void clearPanelShift() {
        PanelShift.removeAll();
        PanelShift.revalidate();
        PanelShift.repaint();
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
        PanelShift = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        StaffPanel = new javax.swing.JPanel();

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

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 1190, 60));

        PanelShift.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setViewportView(StaffPanel);

        PanelShift.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(PanelShift, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 1190, 230));
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
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(DashboardPage.this);
            AddShift dialog = new AddShift(parentFrame, true, DashboardPage.this); // Truyền tham chiếu DashboardPage
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
    EndShift dialog = new EndShift(parentFrame, true, controlId,this);
    
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
 
    private int getOrderIDFromSerialNo(int serialNo) {
    List<PendingBill> pendingBills = BillDAO.getPendingBills();
    if (serialNo > 0 && serialNo <= pendingBills.size()) {
        return pendingBills.get(serialNo - 1).getOrder_id();
    }
    return -1; // Return an invalid order_id if not found
}
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
    private javax.swing.JPanel PanelShift;
    private javax.swing.JTable PendingBill;
    private javax.swing.JPanel StaffPanel;
    private javax.swing.JButton finishBill;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
