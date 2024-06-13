/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app.coffee.product;

import com.app.coffee.product.Category;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Acer
 */
public class NewCategoryPage extends javax.swing.JFrame {
    private List<Category> categories;

    private void setScreen(){
        setDefaultLookAndFeelDecorated(true);
        setSize(500, 380);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public NewCategoryPage() {
        initComponents();
        setScreen();
        
        categories = new ArrayList<>();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formPanel = new javax.swing.JPanel();
        categoryLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        addCategoryButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Category Table");

        formPanel.setBackground(new java.awt.Color(255, 255, 255));
        formPanel.setMinimumSize(new java.awt.Dimension(460, 400));
        formPanel.setPreferredSize(new java.awt.Dimension(460, 400));

        categoryLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        categoryLabel.setText("Category :");

        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        descriptionLabel.setText("Description :");

        txtCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        txtCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryActionPerformed(evt);
            }
        });

        txtDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));

        addCategoryButton.setBackground(new java.awt.Color(51, 255, 0));
        addCategoryButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addCategoryButton.setForeground(new java.awt.Color(255, 255, 255));
        addCategoryButton.setLabel("Add");
        addCategoryButton.setPreferredSize(new java.awt.Dimension(80, 25));
        addCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryButtonActionPerformed(evt);
            }
        });

        returnButton.setBackground(new java.awt.Color(255, 0, 0));
        returnButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        returnButton.setForeground(new java.awt.Color(255, 255, 255));
        returnButton.setText("Return");
        returnButton.setMaximumSize(new java.awt.Dimension(80, 25));
        returnButton.setMinimumSize(new java.awt.Dimension(80, 25));
        returnButton.setPreferredSize(new java.awt.Dimension(80, 25));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        headerPanel.setBackground(new java.awt.Color(255, 51, 0));
        headerPanel.setPreferredSize(new java.awt.Dimension(480, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create a category");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formPanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCategory)
                            .addComponent(txtDescription))))
                .addGap(26, 26, 26))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        getContentPane().add(formPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryActionPerformed

    private void addCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryButtonActionPerformed
        String category = ""; 
        String description = "";
        category = txtCategory.getText();
        description = txtDescription.getText();
        boolean isOk = true;
        
        Category categories = new Category(category, description);
        
    }//GEN-LAST:event_addCategoryButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewCategoryPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewCategoryPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCategoryButton;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables
}
