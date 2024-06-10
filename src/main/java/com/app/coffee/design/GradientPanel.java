/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.design;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    private Color startColor;
    private Color endColor;

    public GradientPanel() {
        this.startColor = Color.BLUE; // Màu bắt đầu
        this.endColor = Color.GREEN; // Màu kết thúc
    }

    public GradientPanel(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        GradientPaint gradientPaint = new GradientPaint(0, 0, startColor, width, height, endColor);
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, 0, width, height);
    }

    public Color getStartColor() {
        return startColor;
    }

    public void setStartColor(Color startColor) {
        this.startColor = startColor;
        repaint();
    }

    public Color getEndColor() {
        return endColor;
    }

    public void setEndColor(Color endColor) {
        this.endColor = endColor;
        repaint();
    }
}
