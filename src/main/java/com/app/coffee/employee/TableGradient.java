/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.employee;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author phamv
 */
public class TableGradient extends DefaultTableCellRenderer{
    
    public TableGradient() {
        this(Color.decode("#4158D0"), Color.decode("#C850C0"));
    }
    public TableGradient(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(false);
    }
    
    private Color color1;
    private Color color2;
    private int x;
    private int width;
    private boolean isSelected;
    private int row;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com= super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Rectangle cellRec=table.getCellRect(row, column, true);
         x = -cellRec.x;
         width = table.getWidth()-cellRec.x;
         this.isSelected=isSelected;
         this.row=row;
        return com;
    }

    @Override
    protected void paintComponent(Graphics g) {
       Graphics2D g2 = (Graphics2D) g.create();
        if (isSelected) {
            g2.setPaint(new GradientPaint(x, 0, color1, width, 0, color2));
            g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        } else if (row % 2 == 0) {
            g2.setPaint(new GradientPaint(x, 0, Color.decode("#ffffff"), width, 0, Color.decode("#434343")));
            g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        }
        g2.dispose();
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
