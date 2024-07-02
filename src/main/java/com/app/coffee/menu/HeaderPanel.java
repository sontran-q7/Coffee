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

        jPanel1.removeAll();

        int x = 24;
        int y = 20;
        int buttonWidth = 109;
        int buttonHeight = 40;
        int gap = 24;

        int panelWidth = (buttonWidth + gap) * categories.size() + 24 + buttonWidth;
        if (panelWidth < jScrollPane1.getWidth()) {
            panelWidth = jScrollPane1.getWidth();
        }

        jPanel1.setPreferredSize(new Dimension(panelWidth, 60));

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

        jPanel1.add(allMenuButton);

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
            jPanel1.add(button);
            categoryButtons.add(button);
            categoryIdList.add(categoryId);

            x += buttonWidth + gap;
        }

        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private void resetButtonColors() {
        allMenuButton.setBackground(new Color(102, 102, 102)); 
        allMenuButton.setForeground(Color.WHITE); 
        for (JButton button : categoryButtons) {
            button.setBackground(new Color(102, 102, 102));
            button.setForeground(Color.WHITE); 
        }
    }
    
    
    public void printProducts(List<ProductMenu> products) {
    for (ProductMenu product : products) {
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Category ID: " + product.getCategoryId());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Size: " + product.getSize());
        System.out.println("Status: " + product.getStatus());
        System.out.println("----------------------------------");
    }
}

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
         
        setLayout(new BorderLayout()); 
        jScrollPane1 = new JScrollPane();
        jPanel1 = new JPanel();
        jPanel1.setLayout(null); 
        jScrollPane1.setViewportView(jPanel1);
        add(jScrollPane1, BorderLayout.CENTER); 
        
        jPanel6.setBackground(new java.awt.Color(255, 102, 0));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select menu");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 40));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(918, 60));
        jPanel1.setLayout(null);

        jScrollPane1.setViewportView(jPanel1);
        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 700, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }
    
    public void refreshUI() {
    jPanel1.revalidate();
    jPanel1.repaint();
}

    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;

    public interface CategoryClickListener {
        void onCategoryClick(int categoryId);
    }
    
}
