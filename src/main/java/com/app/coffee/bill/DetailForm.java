/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.bill;

import com.app.coffee.Backend.Model.OrderDetailModel;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author Admin
 */
public class DetailForm extends javax.swing.JPanel {
    private DefaultTableModel tableModel;
    
    public static void main(String args[]) {
        /* Create and display the form within a JFrame */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Detail Form");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                DetailForm panel = new DetailForm();
                frame.add(panel);
                
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }
    /**
     * Creates new form DetailForm
     */
    public DetailForm() {
        initComponents();
        tableModel = new DefaultTableModel(new Object[]{"Product","Price","Quantity","Description","Size"}, 0); 
        jTable1.setModel(tableModel);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUserName2 = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        OrderTable = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        labelID = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        labelUserName1 = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelDay = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        labelUserName2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        labelUserName2.setForeground(new java.awt.Color(255, 153, 51));

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(452, 762));
        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("Day :");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 50, 30));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Email : ");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 70, 30));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("User name: ");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 80, 30));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("ID Order :");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 80, 30));

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(140, 140, 140), 1, true));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product", "Price", "Quantity", "Description", "Size"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(140, 140, 140));
        jTable1.setSelectionBackground(new java.awt.Color(140, 140, 140));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        OrderTable.setViewportView(jScrollPane1);

        jPanel4.add(OrderTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 480, 240));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 610, 60, 30));

        labelID.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        labelID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));
        jPanel4.add(labelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 110, 30));

        Total.setBackground(new java.awt.Color(255, 255, 255));
        Total.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        Total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));
        jPanel4.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 610, 260, 30));

        labelUserName1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        labelUserName1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));
        jPanel4.add(labelUserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 240, 30));

        labelEmail.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        labelEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));
        jPanel4.add(labelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 240, 33));

        labelDay.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        labelDay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));
        jPanel4.add(labelDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 240, 33));

        jPanel1.setPreferredSize(new java.awt.Dimension(0, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Order Detail");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 530, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void updateDetails(OrderDetailModel orderDetail) {
// for (OrderDetailModel order : orderDetails) {
//        Object[] rowData = {
//            order.getProduct_name(),
//            order.getPrice(),
//            order.getQuantity(),
//            order.getDescription(),
//            order.getSize()
//        };
//           tableModel.addRow(rowData); 
//    }
//        
//        labelID.setText(" " + orderDetails.get(0).getOrder_detail_id()); // Giả sử lấy thông tin từ dòng đầu tiên của danh sách
//        labelUserName1.setText(" " + orderDetails.get(0).getUsername());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String formattedDate = sdf.format(orderDetails.get(0).getDay());
//        Total.setText(" " + orderDetails.get(0).getTotal());
//        labelDay.setText(formattedDate);
//        labelEmail.setText(" " + orderDetails.get(0).getEmail());
        
        
        labelID.setText( " "+orderDetail.getOrder_detail_id());
        labelUserName1.setText( " "+orderDetail.getUsername());
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd");
        String formattedDate = sdf.format(orderDetail.getDay());
        Total.setText(" " + orderDetail.getTotal());
        labelDay.setText(formattedDate);
        labelEmail.setText( " "+orderDetail.getEmail());
        
        Object[] rowData = {
        orderDetail.getProduct_name(),
        orderDetail.getPrice(),
        orderDetail.getQuantity(),
        orderDetail.getDescription(),
        orderDetail.getSize() 
        
    };
        tableModel.addRow(rowData);
    }
//   public void handleOrderDetailSelection(int orderDetailId) {
//    List<OrderDetailModel> orderDetails = selectById(orderDetailId);
//    updateDetails(orderDetails);
//}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane OrderTable;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelUserName1;
    private java.awt.Label labelUserName2;
    // End of variables declaration//GEN-END:variables
}

