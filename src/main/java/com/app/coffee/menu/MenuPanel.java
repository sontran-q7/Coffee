package com.app.coffee.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MenuPanel extends JPanel {

    private CategoryMenu categoryMenu;
    private JComboBox<String> categoryComboBox;
    private List<CategoryMenu> categories;
    private HeaderPanel headerPanel;
    
    private static int bienTam = 0;
    
    private JPanel cardPanelContainer,jPanel13;
    private JScrollPane orderTableScrollPane;
    private JTable orderTable, table;
    private JButton printBillButton, cancelOrderButton;
    private JLabel totalLabel, tableNumberLabel, orderNumberLabel, staffLabel, customerLabel, noteLabel, orderDetailsLabel;
    private JPanel orderDetailsPanel;
    private JScrollPane noteScrollPane;
    private JTextArea noteTextArea;
    private JTextField orderNumberTextField, staffNameTextField, totalTextField, tableNumberTextField, customerNameTextField;
    private DefaultTableModel tableModel;
 
    public MenuPanel() {
        initComponents();
        centerTableCells();
    }

    private void initComponents() {
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardPanelContainer = new JPanel();
        cardPanelContainer.setLayout(new CardLayout());
   
        orderDetailsPanel = createOrderDetailsPanel();
        add(orderDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 440, 750));
        
        JPanel cardProductPanelTest = CardProductPanelTest();
        cardPanelContainer.add(cardProductPanelTest, "cardProductPanelTest");  
        add(cardPanelContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 750));
        
    }

    private JTable createOrderTable() {
        String[] columns = {"No", "Product", "Size", "Quantity", "Sugar", "Price"};
        Object[][] data = {};

        tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; 
            }
        };

        table = new JTable(tableModel);

        tableModel.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                updateTotal();
            }

            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 3) { 
                    Object quantityObj = tableModel.getValueAt(row, column);
                    try {
                        if (quantityObj != null) {
                            int quantity = Integer.parseInt(quantityObj.toString());
                            float price = (float) tableModel.getValueAt(row, 5);
                            if (quantity > 0) {
                                float total = price;
                                tableModel.setValueAt(total, row, 5);  
                            } else {
                                tableModel.setValueAt(0, row, 5);
                            }

                            updateTotal();
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Error: Invalid quantity.");
                    }
                }
            }
        });

        table.setRowHeight(25);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(30);
            table.getColumnModel().getColumn(3).setPreferredWidth(30);
            table.getColumnModel().getColumn(4).setPreferredWidth(30);
            table.getColumnModel().getColumn(5).setPreferredWidth(40);
        }
        return table;
    }

    
    private JPanel createOrderDetailsPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        panel.setPreferredSize(new java.awt.Dimension(452, 762));
        panel.setRequestFocusEnabled(false);
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderNumberTextField = new JTextField();
        tableNumberTextField = new JTextField();
        staffNameTextField = new JTextField();
        customerNameTextField = new JTextField();

        printBillButton = new JButton();
        cancelOrderButton = new JButton();
        noteLabel = new JLabel();
        customerLabel = new JLabel();
        staffLabel = new JLabel();
        orderNumberLabel = new JLabel();
        tableNumberLabel = new JLabel();
        noteScrollPane = new JScrollPane();
        noteTextArea = new JTextArea();
        orderTableScrollPane = new JScrollPane();
        orderTable = createOrderTable();
        totalLabel = new JLabel();
        totalTextField = new JTextField();
        orderDetailsLabel = new JLabel();

        orderTableScrollPane.setViewportView(orderTable);

        JButton deleteRowButton = new JButton("Delete Row");
        deleteRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRowButtonActionPerformed(e);
            }
        });
        deleteRowButton.setBackground(new java.awt.Color(51, 51, 51));
        deleteRowButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        deleteRowButton.setForeground(new java.awt.Color(255, 102, 0));
        deleteRowButton.setBorder(null);
        panel.add(deleteRowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 100, 50));
        
        orderNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        panel.add(orderNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 100, 31));

        tableNumberTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        panel.add(tableNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 270, 29));

        staffNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        panel.add(staffNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 70, 31));

        customerNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        panel.add(customerNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 270, 30));

        printBillButton.setBackground(new java.awt.Color(255, 102, 0));
        printBillButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        printBillButton.setForeground(new java.awt.Color(255, 255, 255));
        printBillButton.setText("Print Bill");
        printBillButton.setBorder(null);
        printBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBillButtonActionPerformed(evt);
            }
        });
        panel.add(printBillButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 640, 100, 50));

        cancelOrderButton.setBackground(new java.awt.Color(51, 51, 51));
        cancelOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        cancelOrderButton.setForeground(new java.awt.Color(255, 102, 0));
        cancelOrderButton.setText("Cancel Order ");
        cancelOrderButton.setBorder(null);
        cancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderButtonActionPerformed(evt);
            }
        });
        panel.add(cancelOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, 100, 50));

        noteLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        noteLabel.setText("Note :");
        panel.add(noteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 50, 40));

        customerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        customerLabel.setText("Customer :");
        panel.add(customerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, 30));

        staffLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        staffLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffLabel.setText("Staff :");
        panel.add(staffLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 80, 30));

        orderNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        orderNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderNumberLabel.setText("No. :");
        panel.add(orderNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 50, 30));

        tableNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        tableNumberLabel.setText("Table No. :");
        panel.add(tableNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 90, 30));

        noteTextArea.setColumns(20);
        noteTextArea.setRows(5);
        noteScrollPane.setViewportView(noteTextArea);
        panel.add(noteScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 260, 50));

        panel.add(orderTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 380, 240));

        totalLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel.setText("Total :");
        panel.add(totalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 60, 30));

        totalTextField.setEditable(false);
        totalTextField.setFont(new java.awt.Font("Segoe UI", 1, 14));
        totalTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTextField.setText("0.0");
        panel.add(totalTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, 120, 30));

        orderDetailsLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        orderDetailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderDetailsLabel.setText("Order Details");
        panel.add(orderDetailsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 220, 40));

        return panel;
    }

    private void deleteRowButtonActionPerformed(ActionEvent evt) {
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow != -1) {
            int option = JOptionPane.showConfirmDialog(MenuPanel.this, "Are you sure you want to delete this row?", "Confirm item deletion", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
                updateRowNumbers();
                updateTotal();
            }
        } else {
            JOptionPane.showMessageDialog(MenuPanel.this, "Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateRowNumbers() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            tableModel.setValueAt(i + 1, i, 0);
        }
    }

    private void updateTotal() {
    double total = 0;
    
    for (int row = 0; row < tableModel.getRowCount(); row++) {
        Object quantityObj = tableModel.getValueAt(row, 3);
        Object valueObj = tableModel.getValueAt(row, 5);
        
        try {
            int quantity = Integer.parseInt(quantityObj.toString());
            double value = Double.parseDouble(valueObj.toString());
            
            total += quantity * value;
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Số lượng hoặc giá trị không hợp lệ.");
        }
    }
    
    totalTextField.setText(String.valueOf(total));
}


    private JPanel CardProductPanelTest() {
        categoryMenu = new CategoryMenu();
        jPanel13 = new JPanel();
        jPanel13.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        jPanel13.setBackground(new Color(204, 204, 204));
        jPanel13.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        
        updateProductPanels();

        JScrollPane rightScrollPane = new JScrollPane(jPanel13);
        rightScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        rightScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(rightScrollPane, BorderLayout.CENTER);

        categoryComboBox = new JComboBox<>();
        categoryComboBox.addItem("All Categories");

        CategoryDaoMenu dao = new CategoryDaoMenu();
        categories = dao.getAllCategories();

        for (CategoryMenu category : categories) {
            categoryComboBox.addItem(category.getCategoryName());
        }

        categoryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = categoryComboBox.getSelectedIndex();

                if (selectedIndex == 0) {
                    categoryMenu.setCategoryId(0);
                } else {
                    CategoryMenu selectedCategory = categories.get(selectedIndex - 1);
                    categoryMenu.setCategoryId(selectedCategory.getCategoryId());
                }
                updateProductPanels();
            }
        });

        panel.add(categoryComboBox, BorderLayout.NORTH);

        headerPanel = new HeaderPanel();
        headerPanel.setCategoryClickListener(new HeaderPanel.CategoryClickListener() {
            @Override
            public void onCategoryClick(int categoryId) {
                if (categoryComboBox != null) {
                    categoryComboBox.setSelectedIndex(getIndexForCategoryId(categoryId));
                }
                updateProductPanels();
            }

            private int getIndexForCategoryId(int categoryId) {
                if (categoryId == 0) {
                    return 0; 
                }
                for (int i = 0; i < categories.size(); i++) {
                    if (categories.get(i).getCategoryId() == categoryId) {
                        return i + 1; 
                    }
                }
                return -1; 
            }
        });

        panel.add(headerPanel, BorderLayout.NORTH);
        return panel;
    }

    private void updateProductPanels() {
        jPanel13.removeAll();

        int currentCategoryId = categoryMenu.getCategoryId();

        List<ProductMenu> products;
        ProductDaoMenu productDaoMenu = new ProductDaoMenu();
        if (currentCategoryId == 0) {
            products = productDaoMenu.getAllProducts();
        } else {
            products = productDaoMenu.getLengthProductsByCategoryId(currentCategoryId);
        }

        for (ProductMenu product : products) {
            JPanel productPanel = CardProduct.createProductPanel(tableModel, new JPanel(), product.getProductName(), product.getPriceS(), product.getPriceL(), product.getImage(), bienTam);
            jPanel13.add(productPanel);
        }

        int numRows = (int) Math.ceil((double) products.size() / 3);
        int rowHeight = 370;
        int gap = 10;
        int preferredHeight = numRows * (rowHeight + gap);
        jPanel13.setPreferredSize(new Dimension(860, preferredHeight));
        
        int topMargin = 10;
        int leftMargin = 30;
        int bottomMargin = 30;
        int rightMargin = 20;
        jPanel13.setBorder(BorderFactory.createEmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin));

        jPanel13.revalidate();
        jPanel13.repaint();
    }

    private void printBillButtonActionPerformed(ActionEvent evt) {
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(MenuPanel.this, "Empty invoice.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(MenuPanel.this, "Do you want to print invoices?", "Confirm invoice printing", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                String orderNo = orderNumberTextField.getText();
                String tableNo = tableNumberTextField.getText();
                String staff = staffNameTextField.getText();
                String customer = customerNameTextField.getText();
                String note = noteTextArea.getText();
                String total = totalTextField.getText();
            
                try {
                    
                    InvoiceDAO invoiceDAO = new InvoiceDAO();
                    Invoice invoice = new Invoice();
                    invoice.setAccountId(1);
                    
                    float total4 = Float.parseFloat(total); 
                    invoice.setTotal(total4);
                    
                    invoice.setDescription(note);
                    invoice.setDay(new Timestamp(System.currentTimeMillis()));
                    
                    for (int i = 0; i < tableModel.getRowCount(); i++) {                 
                        InvoiceDetail detail1 = new InvoiceDetail();

                        ProductDaoMenu productDaoMenu = new ProductDaoMenu();
                        String productName = (String) tableModel.getValueAt(i, 1); 
                        int productId = productDaoMenu.getProductIdByName(productName);
                        detail1.setProductId(productId); 

                        String size = (String) tableModel.getValueAt(i, 2); 
                        detail1.setSize(size);

                        int quantity = (int) tableModel.getValueAt(i, 3); 
                        detail1.setQuantity(quantity);

                        String sugar = (String) tableModel.getValueAt(i, 4); 
                        detail1.setSugar(sugar);

                        if (!orderNo.isEmpty()) {
                            int tableNumber = (int) Float.parseFloat(orderNo);
                            detail1.setTableNumber((int) tableNumber);
                        } else {
                            detail1.setTableNumber(0);
                        }

                        float price = Float.parseFloat(tableModel.getValueAt(i, 5).toString()); 
                        detail1.setPrice(price);

                        invoice.getInvoiceDetails().add(detail1);
                    }
                    
                    invoiceDAO.createInvoice(invoice);

                    invoiceDAO.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                tableModel.setRowCount(0);
                orderNumberTextField.setText("");
                tableNumberTextField.setText("");
                staffNameTextField.setText("");
                customerNameTextField.setText("");
                noteTextArea.setText("");
                totalTextField.setText("");

                JOptionPane.showMessageDialog(MenuPanel.this, "Success.", "Notification", JOptionPane.WARNING_MESSAGE);
                
                Component[] components = jPanel13.getComponents();
                for (Component component : components) {
                    if (component instanceof JPanel) {
                        JPanel productPanel = (JPanel) component;
                        JCheckBox sizeS = null;
                        JCheckBox sizeL = null;
                        JTextField quantityField = null;

                        Component[] productComponents = productPanel.getComponents();
                        for (Component productComponent : productComponents) {
                            if (productComponent instanceof JCheckBox) {
                                JCheckBox checkBox = (JCheckBox) productComponent;
                                if (checkBox.getText().equals("S")) {
                                    sizeS = checkBox;
                                } else if (checkBox.getText().equals("L")) {
                                    sizeL = checkBox;
                                }
                            } else if (productComponent instanceof JTextField) {
                                quantityField = (JTextField) productComponent;
                            }
                        }

                        if (sizeS != null && sizeL != null && quantityField != null) {
                            sizeS.setSelected(false);
                            sizeL.setSelected(false);
                            quantityField.setText("0");
                        }
                    }
                }
                bienTam = 1; 
            }
        }
    }

    private void cancelOrderButtonActionPerformed(ActionEvent evt) {
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(MenuPanel.this, "Empty invoice.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int option = JOptionPane.showConfirmDialog(MenuPanel.this, "Are you sure you want to cancel your order?", "Confirm order cancellation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                tableModel.setRowCount(0); 
                updateTotal(); 
            }
        }
    }

    private void centerTableCells() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < orderTable.getColumnCount(); i++) {
            orderTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
}