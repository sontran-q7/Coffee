/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Acer
 */
public class CustomHeaderRenderer extends DefaultTableCellRenderer{
    Color color;

   public CustomHeaderRenderer(Color color) {
            this.color = color;
            setHorizontalAlignment(JLabel.CENTER); // Center-align text
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                    column);
            label.setForeground(color); // Set the foreground color
            return label;
        }
    }

