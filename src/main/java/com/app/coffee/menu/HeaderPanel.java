package com.app.coffee.menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HeaderPanel extends javax.swing.JPanel {

    private JButton allMenuButton; 
    private List<JButton> categoryButtons; 
    private List<Integer> categoryIdList; 
    private CategoryClickListener categoryClickListener; 
    private CategoryMenu categoryMenu;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel,headerPanelMax;
    private javax.swing.JScrollPane jScrollPane1;

    public HeaderPanel() {
        initComponents();
        customizeScrollBar();
        loadCategoryButtons();
    }

   public void setCategoryClickListener(CategoryClickListener listener) {
        this.categoryClickListener = listener;
    }

    public CategoryClickListener getCategoryClickListener() {
        return this.categoryClickListener;
    }

    private void customizeScrollBar() {
        jScrollPane1.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
        jScrollPane1.getVerticalScrollBar().setUI(new CustomScrollBarUI());
    }

    public void loadCategoryButtons() {
        CategoryDaoMenu dao = new CategoryDaoMenu();
        List<CategoryMenu> categories = dao.getAllCategories();

        if (this.categoryMenu == null) {
            this.categoryMenu = new CategoryMenu();
        }
        headerPanel.removeAll();
        int x = 24;
        int y = 20;
        int buttonWidth = 113;
        int buttonHeight = 40;
        int gap = 24;

        int panelWidth = (buttonWidth + gap) * categories.size() + 24 + buttonWidth;
        if (panelWidth < jScrollPane1.getWidth()) {
            panelWidth = jScrollPane1.getWidth();
        }
        headerPanel.setPreferredSize(new Dimension(panelWidth, 60));

        allMenuButton = new JButton("All Menu");
        allMenuButton.setBackground(new Color(102, 102, 102));
        allMenuButton.setForeground(Color.WHITE);
        allMenuButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        allMenuButton.setBounds(x, y, buttonWidth, buttonHeight);
        allMenuButton.addActionListener(e -> {
            resetButtonColors();
            allMenuButton.setBackground(new Color(102, 102, 102));
            allMenuButton.setForeground(Color.YELLOW);
            if (categoryClickListener != null) {
                categoryClickListener.onCategoryClick(0);
                categoryMenu.setCategoryId(0);
            } else {
                System.err.println("CategoryClickListener is not set!");
            }
        });
        headerPanel.add(allMenuButton);
        categoryButtons = new ArrayList<>();
        categoryIdList = new ArrayList<>();

        x += buttonWidth + gap;
        for (CategoryMenu category : categories) {
            JButton button = new JButton(category.getCategoryName());
            button.setBackground(new Color(102, 102, 102));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Segoe UI", Font.BOLD, 16));
            button.setBounds(x, y, buttonWidth, buttonHeight);
            int categoryId = category.getCategoryId();
            button.addActionListener(e -> {
                resetButtonColors();
                button.setBackground(new Color(102, 102, 102));
                button.setForeground(Color.YELLOW);
                if (categoryClickListener != null) {
                    categoryClickListener.onCategoryClick(categoryId);
                    categoryMenu.setCategoryId(categoryId);
                } else {
                    System.err.println("CategoryClickListener is not set!");
                }
            });
            headerPanel.add(button);
            categoryButtons.add(button);
            categoryIdList.add(categoryId);

            x += buttonWidth + gap;
        }
        headerPanel.revalidate();
        headerPanel.repaint();
    }

    private void resetButtonColors() {
        allMenuButton.setBackground(new Color(102, 102, 102)); 
        allMenuButton.setForeground(Color.WHITE); 
        for (JButton button : categoryButtons) {
            button.setBackground(new Color(102, 102, 102));
            button.setForeground(Color.WHITE); 
        }
    }
  
    @SuppressWarnings("unchecked")
    private void initComponents() {
        headerPanelMax = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        headerPanel = new javax.swing.JPanel();
         
        setLayout(new BorderLayout()); 
        jScrollPane1 = new JScrollPane();
        headerPanel = new JPanel();
        headerPanel.setLayout(null); 
        jScrollPane1.setViewportView(headerPanel);
        add(jScrollPane1, BorderLayout.CENTER); 
        
        headerPanelMax.setBackground(new java.awt.Color(255, 102, 0));
        headerPanelMax.setForeground(new java.awt.Color(255, 255, 255));
        headerPanelMax.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerLabel.setBackground(new java.awt.Color(255, 255, 255));
        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        headerLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Select menu");
        headerPanelMax.add(headerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 40));

        headerPanel.setBackground(new java.awt.Color(255, 102, 0));
        headerPanel.setPreferredSize(new java.awt.Dimension(918, 60));
        headerPanel.setLayout(null);

        jScrollPane1.setViewportView(headerPanel);
        headerPanelMax.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 700, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanelMax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerPanelMax, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }
    
    public void refreshUI() {
        headerPanel.revalidate();
        headerPanel.repaint();
    }

    public interface CategoryClickListener {
        void onCategoryClick(int categoryId);
    }
}
