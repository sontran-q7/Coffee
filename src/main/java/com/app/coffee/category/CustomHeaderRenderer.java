/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.category;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Acer
 */
public class CustomHeaderRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Đặt căn giữa cho tiêu đề của cột
        setHorizontalAlignment(SwingConstants.CENTER);
        
        // Đặt đường viền cho từng cột trong tiêu đề
        JTableHeader header = table.getTableHeader();
        if (header != null) {
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(220, 220, 220))); // Đường viền đen giữa các cột
        }
        // Đặt cỡ chữ cho tiêu đề của cột
        //setFont(new Font("Arial", Font.BOLD, 14)); // Thay "Arial" và 14 bằng font và kích thước mong muốn
        
        return this;
    }
}