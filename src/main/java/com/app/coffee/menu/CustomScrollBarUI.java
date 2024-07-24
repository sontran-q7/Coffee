package com.app.coffee.menu;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = new Color(255, 102, 0); 
            this.trackColor = new Color(255, 102, 0);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            JButton button = super.createDecreaseButton(orientation);
            button.setBackground(new Color(255, 102, 0));
            button.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0))); 
            return button;
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            JButton button = super.createIncreaseButton(orientation);
            button.setBackground(new Color(255, 102, 0)); 
            button.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0)));
            return button;
        }
    }
