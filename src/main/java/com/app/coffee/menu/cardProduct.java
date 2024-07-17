package com.app.coffee.menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class CardProduct extends javax.swing.JPanel {
    private int productCount = 0;
    private JLabel productCountLabel,priceLabel,productNameLabel;
    private JCheckBox checkBoxSizeS, checkBoxSugar50,checkBoxSizeL, checkBoxSugar100;
    private float priceS, priceL;

    public CardProduct() {
    }

    public static JPanel createProductPanel(DefaultTableModel tableModel, JPanel productPanel, String product_name, float priceS, float priceL, String image) {
        CardProduct cardProductPanel = new CardProduct();
        cardProductPanel.priceS = priceS;
        cardProductPanel.priceL = priceL;
        JPanel jPanel20 = cardProductPanel.createPanel(Color.WHITE, new Dimension(260, 370));
        JButton MinusButton14 = cardProductPanel.createButton("-", new Color(102, 102, 102), new Font("Segoe UI", Font.ITALIC, 28));
        JButton PlusButton14 = cardProductPanel.createButton("+", new Color(255, 102, 0), new Font("Segoe UI", Font.ITALIC, 28));
        cardProductPanel.checkBoxSizeS = cardProductPanel.createCheckBox("S", new Font("Segoe UI", Font.PLAIN, 14));
        cardProductPanel.checkBoxSizeL = cardProductPanel.createCheckBox("L", new Font("Segoe UI", Font.PLAIN, 14));
        cardProductPanel.checkBoxSugar50 = cardProductPanel.createCheckBox("50%", null);
        cardProductPanel.checkBoxSugar100 = cardProductPanel.createCheckBox("100%", null);

        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(cardProductPanel.checkBoxSizeS);
        sizeGroup.add(cardProductPanel.checkBoxSizeL);
        ButtonGroup sugarGroup = new ButtonGroup();
        sugarGroup.add(cardProductPanel.checkBoxSugar50);
        sugarGroup.add(cardProductPanel.checkBoxSugar100);
        
        cardProductPanel.productCountLabel = cardProductPanel.createLabel("0", new Font("Segoe UI", Font.PLAIN, 14), SwingConstants.CENTER);
        cardProductPanel.productCountLabel.setForeground(Color.WHITE);        
        JLabel jLabel134 = cardProductPanel.createLabel("Sugar :", new Font("Segoe UI", Font.BOLD, 14), null, new Color(51, 51, 51));
        JLabel jLabel135 = cardProductPanel.createLabel("Cup size :", new Font("Segoe UI", Font.BOLD, 14), SwingConstants.CENTER, new Color(51, 51, 51));
        
        ImageIcon imageIcon = null;
        String imageDir = System.getProperty("user.dir") + "/src/main/java/com/app/coffee/image";
        if (image != null && !image.isEmpty()) {
            String imagePath = imageDir + "/" + image;
            imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
        
        JLabel jLabel136 = cardProductPanel.createLabel("image null", null, SwingConstants.CENTER);
        jLabel136.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        Image scaledImage = imageIcon.getImage().getScaledInstance(160, 150, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(scaledImage);
        jLabel136.setIcon(resizedImageIcon);
    
        cardProductPanel.productNameLabel = cardProductPanel.createLabel(product_name, new Font("Segoe UI", Font.ITALIC, 18), SwingConstants.CENTER, new Color(255, 51, 0));
        JLabel jLabel138 = cardProductPanel.createLabel("Price", new Font("Segoe UI", Font.BOLD, 18), SwingConstants.CENTER, new Color(255, 102, 0));
        cardProductPanel.priceLabel = cardProductPanel.createLabel(String.format("%.2f USD", priceS), new Font("Segoe UI", Font.BOLD, 12), null);

        PlusButton14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!cardProductPanel.checkBoxSizeS.isSelected() && !cardProductPanel.checkBoxSizeL.isSelected()) {
                    cardProductPanel.checkBoxSizeS.setSelected(true);
                }
                if (!cardProductPanel.checkBoxSugar50.isSelected() && !cardProductPanel.checkBoxSugar100.isSelected()) {
                    cardProductPanel.checkBoxSugar100.setSelected(true);
                }
                cardProductPanel.productCount++;
                cardProductPanel.productCountLabel.setText(String.valueOf(cardProductPanel.productCount));
                float price = cardProductPanel.checkBoxSizeS.isSelected() ? cardProductPanel.priceS : cardProductPanel.priceL;
                String size = cardProductPanel.checkBoxSizeS.isSelected() ? "S" : "L";
                String sugar = cardProductPanel.checkBoxSugar100.isSelected() ? "100%" : "50%";
                addOrUpdateProductInTable(tableModel, product_name, size, sugar, price);
            }
        });

        MinusButton14.addActionListener(e -> {
            int rowCount = tableModel.getRowCount();       
            if (rowCount > 0) {
                cardProductPanel.productCount--;
                cardProductPanel.productCountLabel.setText(String.valueOf(cardProductPanel.productCount));
                String productName = cardProductPanel.productNameLabel.getText();
                String size = cardProductPanel.checkBoxSizeS.isSelected() ? "S" : "L";
                String sugar = cardProductPanel.checkBoxSugar100.isSelected() ? "100%" : "50%";
                float price = size.equals("S") ? cardProductPanel.priceS : cardProductPanel.priceL;
                
                int rowIndex = findProductInTable(tableModel, productName, size, sugar);
                if (rowIndex != -1) {
                    int currentQuantity = (int) tableModel.getValueAt(rowIndex, 3);
                    if (currentQuantity > 1) {
                        tableModel.setValueAt(currentQuantity - 1, rowIndex, 3);
                        float totalPrice =  price;
                        tableModel.setValueAt(totalPrice, rowIndex, 5);
                    } else {
                        tableModel.removeRow(rowIndex);
                        updateSTT(tableModel); 
                    }
                }
            } else {
                JOptionPane.showMessageDialog(cardProductPanel, "The product has not been added to the table so it cannot be reduced.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        cardProductPanel.checkBoxSizeS.addActionListener(e -> cardProductPanel.updatePrice(priceS));
        cardProductPanel.checkBoxSizeL.addActionListener(e -> cardProductPanel.updatePrice(priceL));

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
                                                .addComponent(cardProductPanel.checkBoxSugar50)
                                                .addGap(20, 20, 20)
                                                .addComponent(cardProductPanel.checkBoxSugar100))
                                        .addGroup(jPanel20Layout.createSequentialGroup()
                                                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel20Layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addComponent(MinusButton14, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(cardProductPanel.productCountLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel20Layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jLabel135, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cardProductPanel.checkBoxSizeS)))
                                                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(cardProductPanel.checkBoxSizeL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(PlusButton14, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel20Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(cardProductPanel.productNameLabel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel20Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel136, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(cardProductPanel.priceLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
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
                                                .addComponent(jLabel138, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(cardProductPanel.priceLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(cardProductPanel.productNameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel135)
                                        .addComponent(cardProductPanel.checkBoxSizeS)
                                        .addComponent(cardProductPanel.checkBoxSizeL))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel134)
                                        .addComponent(cardProductPanel.checkBoxSugar50)
                                        .addComponent(cardProductPanel.checkBoxSugar100))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(MinusButton14)
                                        .addComponent(cardProductPanel.productCountLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PlusButton14))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        GroupLayout productPanelLayout = new GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        productPanelLayout.setHorizontalGroup(
                productPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addGroup(productPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(productPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(jPanel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        productPanelLayout.setVerticalGroup(
                productPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addGroup(productPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(productPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(jPanel20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );

        return jPanel20;
    }

    private static int findProductInTable(DefaultTableModel tableModel, String productName, String size, String sugar) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String existingProductName = (String) tableModel.getValueAt(i, 1);
            String existingSize = (String) tableModel.getValueAt(i, 2);
            String existingSugar = (String) tableModel.getValueAt(i, 4);

            if (existingProductName.equals(productName) && existingSize.equals(size) && existingSugar.equals(sugar)) {
                return i;
            }
        }
        return -1;
    }

    private static void addOrUpdateProductInTable(DefaultTableModel tableModel, String productName, String size, String sugar, float price) {
        int rowIndex = findProductInTable(tableModel, productName, size, sugar);
        if (rowIndex != -1) {
            int currentQuantity = (int) tableModel.getValueAt(rowIndex, 3);
            float totalPrice = (float) tableModel.getValueAt(rowIndex, 5);
            currentQuantity++;
            totalPrice = price;
            tableModel.setValueAt(currentQuantity, rowIndex, 3);
            tableModel.setValueAt(totalPrice, rowIndex, 5);
        } else {
            Object[] rowData = {
                    tableModel.getRowCount() + 1,
                    productName,
                    size,
                    1, 
                    sugar,
                    price 
            };
            tableModel.addRow(rowData);
        }
    }

    private static void updateSTT(DefaultTableModel tableModel) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(i + 1, i, 0);
        }
    }

    private void updatePrice(float price) {
        priceLabel.setText(String.format("%.2f USD", price));
    }

    private JButton createButton(String text, Color background, Font font) {
        JButton button = new JButton(text);
        button.setBackground(background);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        return button;
    }

    private JLabel createLabel(String text, Font font, Integer horizontalAlignment) {
        return createLabel(text, font, horizontalAlignment, null);
    }

    private JLabel createLabel(String text, Font font, Integer horizontalAlignment, Color foreground) {
        JLabel label = new JLabel(text);
        if (font != null) label.setFont(font);
        if (horizontalAlignment != null) label.setHorizontalAlignment(horizontalAlignment);
        if (foreground != null) label.setForeground(foreground);
        return label;
    }

    private JCheckBox createCheckBox(String text, Font font) {
        JCheckBox checkBox = new JCheckBox(text);
        if (font != null) checkBox.setFont(font);
        return checkBox;
    }

    private JPanel createPanel(Color background, Dimension preferredSize) {
        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setPreferredSize(preferredSize);
        return panel;
    }
}