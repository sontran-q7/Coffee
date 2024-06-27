package com.app.coffee.menu;

import com.app.coffee.product.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CardProductPanel extends JPanel {

    private DefaultTableModel tableModel;
    private Component parentComponent;
    private JPanel jPanel13;
    private CategoryMenu categoryMenu;

    public CardProductPanel() {
        initUI();
    }

    private void initUI() {
        categoryMenu = new CategoryMenu();
        jPanel13 = new JPanel();
        jPanel13.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        jPanel13.setBackground(new Color(204, 204, 204));
        jPanel13.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        System.out.println("Initializing UI");

        updateProductPanels();

        categoryMenu.addPropertyChangeListener(evt -> {
            if ("category_id".equals(evt.getPropertyName())) {
                updateProductPanels();
            }
        });

        JScrollPane rightScrollPane = new JScrollPane(jPanel13);
        rightScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        rightScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        setLayout(new BorderLayout());
        add(rightScrollPane, BorderLayout.CENTER);

        
        // ComboBox for selecting categories
//        JComboBox<String> categoryComboBox = new JComboBox<>();
//        categoryComboBox.addItem("All Categories");
//        categoryComboBox.addItem("Category 1");
//        categoryComboBox.addItem("Category 2");
//        categoryComboBox.addItem("Category 3");
//
//        categoryComboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int selectedIndex = categoryComboBox.getSelectedIndex();
//                if (selectedIndex == 0) {
//                    categoryMenu.setCategoryId(0);
//                } else {
//                    categoryMenu.setCategoryId(selectedIndex); 
//                }
//            }
//        });
//
//        add(categoryComboBox, BorderLayout.NORTH);
        
//        List<String> lengthCategory = new ArrayList<>();
//        CategoryDaoMenu dao = new CategoryDaoMenu();
//        List<CategoryMenu> categories = dao.getAllCategories();
//
//        for (CategoryMenu category : categories) {
//            lengthCategory.add(category.getCategoryName());
//        }
//
//        HeaderPanel headerPanel = new HeaderPanel();
//        headerPanel.setCategoryClickListener(categoryName -> {
//            if (jPanel13 != null) {
//                jPanel13.removeAll();
//            }
//
//            int selectedIndex = lengthCategory.indexOf(categoryName); 
//
//            if (selectedIndex == -1) {
//                categoryMenu.setCategoryId(0); // Xử lý trường hợp không tìm thấy categoryName
//            } else {
//                CategoryMenu selectedCategory = categories.get(selectedIndex);
//                categoryMenu.setCategoryId(selectedCategory.getCategoryId()); // Thiết lập categoryId từ selectedCategory
//            }
//
//            // Cập nhật giao diện nếu cần thiết
//            revalidate();
//            repaint();
//        });


    }

//    private JComboBox<String> categoryComboBox;
//    private List<CategoryMenu> categories;
//
//    private void initUI() {
//        categoryMenu = new CategoryMenu();
//        jPanel13 = new JPanel();
//        jPanel13.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
//        jPanel13.setBackground(new Color(204, 204, 204));
//        jPanel13.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
//
//        System.out.println("Initializing UI");
//
//        updateProductPanels();
//
//        categoryMenu.addPropertyChangeListener(evt -> {
//            if ("category_id".equals(evt.getPropertyName())) {
//                updateProductPanels();
//            }
//        });
//
//        JScrollPane rightScrollPane = new JScrollPane(jPanel13);
//        rightScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        rightScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//
//        setLayout(new BorderLayout());
//        add(rightScrollPane, BorderLayout.CENTER);
//
//        categoryComboBox = new JComboBox<>();
//        categoryComboBox.addItem("All Categories");
//
//        CategoryDaoMenu dao = new CategoryDaoMenu();
//        categories = dao.getAllCategories();
//
//        for (CategoryMenu category : categories) {
//            categoryComboBox.addItem(category.getCategoryName());
//        }
//
//        categoryComboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int selectedIndex = categoryComboBox.getSelectedIndex();
//
//                if (selectedIndex == 0) {
//                    categoryMenu.setCategoryId(0);
//                } else {
//                    CategoryMenu selectedCategory = categories.get(selectedIndex - 1); // vì index 0 là "All Categories"
//                    categoryMenu.setCategoryId(selectedCategory.getCategoryId());
//                }
//            }
//        });
//
//        add(categoryComboBox, BorderLayout.NORTH);
//
//        HeaderPanel headerPanel = new HeaderPanel();
//        headerPanel.setCategoryClickListener(categoryName -> {
//            if (jPanel13 != null) {
//                jPanel13.removeAll();
//            }
//
//            int selectedIndex = categoryComboBox.getSelectedIndex(); 
//
//            if (selectedIndex == -1) {
//                categoryMenu.setCategoryId(0); 
//            } else {
//                CategoryMenu selectedCategory = categories.get(selectedIndex - 1);
//                categoryMenu.setCategoryId(selectedCategory.getCategoryId());
//            }
//
//            revalidate();
//            repaint();
//        });
//    }
    private void updateProductPanels() {
        jPanel13.removeAll();

        List<ProductMenu> products;
        if (categoryMenu.getCategoryId() == 0) {
            products = getAllProducts();
        } else {
            products = getProductsByCategoryId(categoryMenu.getCategoryId());
        }

        for (ProductMenu product : products) {
            JPanel productPanel = CardProduct.createProductPanel(tableModel, new JPanel(), product.getProductName(), product.getPrice());
            jPanel13.add(productPanel);
        }

        int numRows = (int) Math.ceil((double) products.size() / 3);
        int rowHeight = 370;
        int gap = 20;
        int preferredHeight = numRows * (rowHeight + gap);
        jPanel13.setPreferredSize(new Dimension(860, preferredHeight));

        int topMargin = 10;
        int leftMargin = 10;
        int bottomMargin = 10;
        int rightMargin = 10;
        jPanel13.setBorder(BorderFactory.createEmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin));

        jPanel13.revalidate();
        jPanel13.repaint();
    }


    public List<ProductMenu> getProductsByCategoryId(int categoryId) {
        List<ProductMenu> products = new ArrayList<>();
        String sql;
        if (categoryId == 0) {
            sql = "SELECT * FROM product WHERE status = 1";
        } else {
            sql = "SELECT * FROM product WHERE category_id = ? AND status = 1";
        }

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            if (categoryId != 0) {
                pstmt.setInt(1, categoryId);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("product_id");
                    int categoryIdFromDb = rs.getInt("category_id");
                    String productName = rs.getString("product_name");
                    float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    String size = rs.getString("size");
                    int status = rs.getInt("status");

                    ProductMenu p = new ProductMenu(productName);
                    ProductMenu product = new ProductMenu(productId, productName, price, categoryIdFromDb, description, size, status);
                     
                    products.add(p);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error!! " + e.getMessage());
        }
        return products;
    }
    
    private List<ProductMenu> getAllProducts() {
        List<ProductMenu> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE status = 1"; 

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int categoryId = rs.getInt("category_id");
                String productName = rs.getString("product_name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                String size = rs.getString("size");
                int status = rs.getInt("status");

                ProductMenu product = new ProductMenu(productId, productName, price, categoryId, description, size, status);
                products.add(product);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error retrieving products: " + e.getMessage());
        }

        return products;
    }
}
