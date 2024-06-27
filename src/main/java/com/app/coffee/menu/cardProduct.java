/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CardProduct extends javax.swing.JPanel {

    private int productCount = 0;
    private JLabel jLabel133; // Để đảm bảo rằng jLabel133 được khởi tạo và sử dụng đúng

    /**
     * Creates new form ProductPanel
     */
    public CardProduct() {
//        initComponents();
    }

    public static JPanel createProductPanel(DefaultTableModel tableModel, JPanel productPanel, String product_name, float price) {
    CardProduct cardProductPanel = new CardProduct();
    JPanel jPanel20 = cardProductPanel.createPanel(Color.WHITE, new Dimension(260, 370));

    JButton MinusButton14 = cardProductPanel.createButton("-", new Color(102, 102, 102), new Font("Segoe UI", Font.ITALIC, 28));
    JButton PlusButton14 = cardProductPanel.createButton("+", new Color(255, 102, 0), new Font("Segoe UI", Font.ITALIC, 24));

    JCheckBox jCheckBox71 = cardProductPanel.createCheckBox("S", new Font("Segoe UI", Font.PLAIN, 14));
    JCheckBox jCheckBox72 = cardProductPanel.createCheckBox("L", new Font("Segoe UI", Font.PLAIN, 14));
    JCheckBox jCheckBox73 = cardProductPanel.createCheckBox("50%", null);
    JCheckBox jCheckBox74 = cardProductPanel.createCheckBox("100%", null);

    ButtonGroup sizeGroup = new ButtonGroup();
    sizeGroup.add(jCheckBox71);
    sizeGroup.add(jCheckBox72);

    ButtonGroup sugarGroup = new ButtonGroup();
    sugarGroup.add(jCheckBox73);
    sugarGroup.add(jCheckBox74);

    cardProductPanel.jLabel133 = cardProductPanel.createLabel("0", new Font("Segoe UI", Font.PLAIN, 14), SwingConstants.CENTER);
    JLabel jLabel134 = cardProductPanel.createLabel("Sugar :", new Font("Segoe UI", Font.BOLD, 14), null, new Color(51, 51, 51));
    JLabel jLabel135 = cardProductPanel.createLabel("Cup size :", new Font("Segoe UI", Font.BOLD, 14), SwingConstants.CENTER, new Color(51, 51, 51));
    JLabel jLabel136 = cardProductPanel.createLabel("image", null, SwingConstants.CENTER);
    jLabel136.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    JLabel jLabel137 = cardProductPanel.createLabel(product_name, new Font("Segoe UI", Font.ITALIC, 18), SwingConstants.CENTER, new Color(255, 51, 0));
    JLabel jLabel138 = cardProductPanel.createLabel("Price", new Font("Segoe UI", Font.BOLD, 18), SwingConstants.CENTER, new Color(255, 102, 0));
    JLabel jLabel140 = cardProductPanel.createLabel(String.format("%.2f USD", price), new Font("Segoe UI", Font.BOLD, 12), null);

    MinusButton14.addActionListener(e -> cardProductPanel.minusButtonActionPerformed(e));
    PlusButton14.addActionListener(e -> cardProductPanel.plusButtonActionPerformed(e));

    GroupLayout jPanel20Layout = new GroupLayout(jPanel20);
    jPanel20.setLayout(jPanel20Layout);
    jPanel20Layout.setHorizontalGroup(
        jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel134, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox73)
                        .addGap(20, 20, 20)
                        .addComponent(jCheckBox74))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(MinusButton14, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(cardProductPanel.jLabel133, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel135, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox71)))
                        .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox72, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlusButton14, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel137, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel136, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel140, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel138, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
    );
    jPanel20Layout.setVerticalGroup(
        jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel136, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel138, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel140, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel137, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox71, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox72, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox73, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox74, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(MinusButton14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardProductPanel.jLabel133, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlusButton14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
    );

    productPanel.add(jPanel20);
    return productPanel;
}


    private JPanel createPanel(Color bgColor, Dimension prefSize) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        panel.setPreferredSize(prefSize);
        return panel;
    }

    private JButton createButton(String text, Color bgColor, Font font) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        return button;
    }

    private JCheckBox createCheckBox(String text, Font font) {
        JCheckBox checkBox = new JCheckBox(text);
        if (font != null) {
            checkBox.setFont(font);
        }
        return checkBox;
    }

    private JLabel createLabel(String text, Font font, Integer horizontalAlignment) {
        return createLabel(text, font, horizontalAlignment, null);
    }

    private JLabel createLabel(String text, Font font, Integer horizontalAlignment, Color fgColor) {
        JLabel label = new JLabel(text);
        if (font != null) {
            label.setFont(font);
        }
        if (horizontalAlignment != null) {
            label.setHorizontalAlignment(horizontalAlignment);
        }
        if (fgColor != null) {
            label.setForeground(fgColor);
        }
        return label;
    }

    private void jCheckBox74ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void minusButtonActionPerformed(ActionEvent evt) {
    if (productCount > 0) {
        productCount--;
    } else {
        JOptionPane optionPane = new JOptionPane("The product quantity is already 0, it cannot be reduced further.", JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Notification");
        
        dialog.setLocation(dialog.getX() - 230, dialog.getY() - 100);
        
        dialog.setVisible(true);
    }
    jLabel133.setText(String.valueOf(productCount));
}


    private void plusButtonActionPerformed(ActionEvent evt) {
        productCount++;
        jLabel133.setText(String.valueOf(productCount));
    }
    
    private javax.swing.JButton MinusButton14,PlusButton14;
    private javax.swing.JCheckBox jCheckBox71,jCheckBox72,jCheckBox73,jCheckBox74;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JPanel jPanel20;
}

