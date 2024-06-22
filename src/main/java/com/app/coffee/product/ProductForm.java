/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.product;


import java.awt.CardLayout;

/**
 *
 * @author anhso
 */
public class ProductForm extends javax.swing.JPanel {

    /**
     * Creates new form ProductForm
     */
    public ProductForm() {
        initComponents();
        loadPanels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Productpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ProductFormPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EditProduct = new javax.swing.JButton();
        DeleteProduct = new javax.swing.JButton();
        AddProduct = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Manager");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1072, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, -1));

        Productpanel.setBackground(new java.awt.Color(255, 255, 255));
        Productpanel.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Image", "Category_name", "Name", "Size", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Productpanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(Productpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 760, 540));

        ProductFormPanel.setBackground(new java.awt.Color(255, 255, 255));
        ProductFormPanel.setLayout(new java.awt.CardLayout());
        add(ProductFormPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 470, 540));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Product form:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Product list:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 210, 30));

        EditProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditProduct.setForeground(new java.awt.Color(255, 102, 0));
        EditProduct.setText("Edit");
        EditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProductActionPerformed(evt);
            }
        });
        add(EditProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 110, 100, 30));

        DeleteProduct.setBackground(new java.awt.Color(51, 51, 51));
        DeleteProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        DeleteProduct.setText("Delete");
        DeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProductActionPerformed(evt);
            }
        });
        add(DeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 110, 100, 30));

        AddProduct.setBackground(new java.awt.Color(255, 102, 0));
        AddProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddProduct.setForeground(new java.awt.Color(255, 255, 255));
        AddProduct.setText("Add");
        AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductActionPerformed(evt);
            }
        });
        add(AddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductActionPerformed
        showPanel("addProduct");
    }//GEN-LAST:event_AddProductActionPerformed

    private void DeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteProductActionPerformed

    private void EditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProductActionPerformed
        showPanel("editProduct");
    }//GEN-LAST:event_EditProductActionPerformed

      private void loadPanels() {
        Addproduct addproduct = new Addproduct();
        EditProduct editProduct = new EditProduct();
        ProductFormPanel.add(addproduct,"addProduct");
        ProductFormPanel.add(editProduct,"editProduct");
    }
   private void showPanel(String panelName) {
        ((CardLayout)ProductFormPanel.getLayout()).show(ProductFormPanel, panelName);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProduct;
    private javax.swing.JButton DeleteProduct;
    private javax.swing.JButton EditProduct;
    private javax.swing.JPanel ProductFormPanel;
    private javax.swing.JPanel Productpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
