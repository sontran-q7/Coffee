package com.app.coffee.menu;

import com.itextpdf.text.DocumentException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.logging.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MenuPanel extends JPanel {

    private String userName;
    private javax.swing.JLabel tableLable, staffTextField, totalLabel, noteLabel, orderDetailsLabel , guestsBroughtLable , changeLable, dummyComponent;
    private javax.swing.JTextField tableNoTextField, totalTextField, guestsBroughtTextField, changeTextField, noteTextField;
    private javax.swing.JScrollPane orderTableScrollPane, noteScrollPane;
    private javax.swing.JTable orderTable, table;
    private javax.swing.JButton printBillButton, cancelOrderButton;
    private javax.swing.JPanel orderDetailsPanel, cardPanelContainer, CardProductPanel;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.table.DefaultTableModel tableModel;

    private CategoryMenu categoryMenu;
    private List<CategoryMenu> categories;
    private HeaderPanel headerPanel;
    
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
        
        JPanel cardProductPanelTest = CardProductPanel();
        cardPanelContainer.add(cardProductPanelTest, "cardProductPanelTest");  
        add(cardPanelContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 750));
    }

    private JTable createOrderTable() {
        String[] columns = {"No", "Product", "Size", "Quantity", "Sugar", "Price", "Note"};
        Object[][] data = {};

        tableModel = new DefaultTableModel(data, columns) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return Integer.class; 
                } else if (columnIndex == 5) {
                    return Float.class;
                }
                return String.class; 
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 6;
            }
        };
                
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 3) {
                        Object value = tableModel.getValueAt(row, column);
                        try {
                            int quantity = Integer.parseInt(value.toString());
                            if (quantity < 0) {
                                throw new NumberFormatException("Negative number");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number for Quantity", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                            tableModel.setValueAt(0, row, column);
                        }
                    }
                }
            }
        });
        
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
                            int quantity = (Integer) quantityObj; 
                            float price = (Float) tableModel.getValueAt(row, 5); 
                            if (quantity > 0) {
                                float total = price;
                                tableModel.setValueAt(total, row, 5); 
                            } else {
                                tableModel.setValueAt(0.0f, row, 5);
                            }
                            updateTotal();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid quantity.");
                    }
                }
            }
        });
        
        table = new JTable(tableModel);
        table.setRowHeight(25);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(1).setPreferredWidth(90);
            table.getColumnModel().getColumn(2).setPreferredWidth(15);
            table.getColumnModel().getColumn(3).setPreferredWidth(50);
            table.getColumnModel().getColumn(4).setPreferredWidth(30);
            table.getColumnModel().getColumn(5).setPreferredWidth(30);
            table.getColumnModel().getColumn(6).setPreferredWidth(35);
        }      
        table.getColumnModel().getColumn(3).setCellEditor(new QuantityCellEditor(new JLabel()));
        table.getColumnModel().getColumn(6).setCellEditor(new NoteCellEditor(new JLabel()));
        
        return table;
    }

    private JPanel createOrderDetailsPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        panel.setPreferredSize(new java.awt.Dimension(452, 762));
        panel.setRequestFocusEnabled(false);
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dummyComponent = new JLabel();
        panel.add(dummyComponent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        orderTable = createOrderTable();
        printBillButton = new JButton();
        cancelOrderButton = new JButton();
        noteScrollPane = new JScrollPane();
        noteTextField = new JTextField(); 
        orderTableScrollPane = new JScrollPane();
        totalLabel = new JLabel();
        totalTextField = new JTextField();
        orderDetailsLabel = new JLabel();
        staffTextField = new JLabel();
        tableNoTextField = new JTextField();
        noteLabel = new JLabel();
        tableLable = new JLabel();
        guestsBroughtLable = new JLabel();
        guestsBroughtTextField = new JTextField();
        changeLable = new JLabel();
        changeTextField = new JTextField();
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
        panel.add(deleteRowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 100, 50));

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
        panel.add(printBillButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 680, 100, 50));

        cancelOrderButton.setBackground(new java.awt.Color(51, 51, 51));
        cancelOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        cancelOrderButton.setForeground(new java.awt.Color(255, 102, 0));
        cancelOrderButton.setText("Cancel Order");
        cancelOrderButton.setBorder(null);
        cancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderButtonActionPerformed(evt);
            }
        });
        panel.add(cancelOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 680, 100, 50));

        noteLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        noteLabel.setText("Note:");
        panel.add(noteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 50, 50));

        panel.add(tableNoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 300, 35));

        tableLable.setFont(new java.awt.Font("Segoe UI", 1, 14));
        tableLable.setText("Table No:");
        panel.add(tableLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 90, 35));

        staffTextField.setFont(new java.awt.Font("Segoe UI", 1, 14));
        staffTextField.setText("");
        panel.add(staffTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        noteTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(noteScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 330, 50));
        noteScrollPane.setViewportView(noteTextField);
            
        panel.add(orderTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 380, 310));

        totalLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel.setText("Total:");
        panel.add(totalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 510, 60, 35));

        totalTextField.setEditable(false);
        totalTextField.setFont(new java.awt.Font("Segoe UI", 1, 14));
        totalTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTextField.setText("0");
        panel.add(totalTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 330, 35));

        guestsBroughtLable.setFont(new java.awt.Font("Segoe UI", 1, 14));
        guestsBroughtLable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        guestsBroughtLable.setText("Give:");
        panel.add(guestsBroughtLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 560, 60, 35));

        guestsBroughtTextField.setFont(new java.awt.Font("Segoe UI", 1, 14));
        guestsBroughtTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        guestsBroughtTextField.setText("0");
        panel.add(guestsBroughtTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 330, 35));

        changeLable.setFont(new java.awt.Font("Segoe UI", 1, 14));
        changeLable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        changeLable.setText("Change:");
        panel.add(changeLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 610, 60, 35));

        changeTextField.setEditable(false);
        changeTextField.setFont(new java.awt.Font("Segoe UI", 1, 14));
        changeTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        changeTextField.setText("0");
        panel.add(changeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 330, 35));

        orderDetailsLabel.setFont(new java.awt.Font("Segoe UI", 1, 26));
        orderDetailsLabel.setForeground(new java.awt.Color(255, 102, 0));
        orderDetailsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderDetailsLabel.setText("Order Details");
        panel.add(orderDetailsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 220, 40));

        guestsBroughtTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateChange();
            }

            private void updateChange() {
                String totalStr = totalTextField.getText().trim();
                String guestsBroughtStr = guestsBroughtTextField.getText().trim();
                if (!guestsBroughtStr.isEmpty()) {
                    try {
                        double total = Double.parseDouble(totalStr);
                        double guestsBrought = Double.parseDouble(guestsBroughtStr);

                        double change = guestsBrought - total;
                        changeTextField.setText(String.format("%.1f", change));
                    } catch (NumberFormatException ex) {
                        changeTextField.setText("0");
                    }
                } else {
                    changeTextField.setText("0");
                }
            }
        });

        guestsBroughtTextField.addFocusListener(new NumericTextFieldFocusListener(dummyComponent)); 
        tableNoTextField.addFocusListener(new NumericTextFieldFocusListener(dummyComponent)); 
        noteTextField.addFocusListener(new TextFieldFocusListener(dummyComponent)); 
        
        tableNoTextField.setName("Table Number");
        noteTextField.setName("Note");
        guestsBroughtTextField.setName("Guests Brought");

        return panel;
    }

    private JPanel CardProductPanel() {
        categoryMenu = new CategoryMenu();
        CardProductPanel = new JPanel();
        CardProductPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        CardProductPanel.setBackground(new Color(204, 204, 204));
        CardProductPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        
        updateProductPanels();

        JScrollPane rightScrollPane = new JScrollPane(CardProductPanel);
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
        CardProductPanel.removeAll();
        int currentCategoryId = categoryMenu.getCategoryId();

        List<ProductMenu> products;
        ProductDaoMenu productDaoMenu = new ProductDaoMenu();
        if (currentCategoryId == 0) {
            products = productDaoMenu.getAllProducts();
        } else {
            products = productDaoMenu.getLengthProductsByCategoryId(currentCategoryId);
        }

        for (ProductMenu product : products) {
            JPanel productPanel = CreateCardProduct.createProductPanel(tableModel, new JPanel(), product.getProductName(), product.getPriceS(), product.getPriceL(), product.getImage());
            CardProductPanel.add(productPanel);
        }

        int numRows = (int) Math.ceil((double) products.size() / 3);
        int rowHeight = 370;
        int gap = 10;
        int preferredHeight = numRows * (rowHeight + gap);
        CardProductPanel.setPreferredSize(new Dimension(860, preferredHeight));
        
        int topMargin = 10;
        int leftMargin = 30;
        int bottomMargin = 30;
        int rightMargin = 20;
        CardProductPanel.setBorder(BorderFactory.createEmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin));

        CardProductPanel.revalidate();
        CardProductPanel.repaint();
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
                JOptionPane.showMessageDialog(MenuPanel.this, "Invalid quantity or value.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        totalTextField.setText(String.valueOf(total));
    }
    
    private void removeZeroQuantityRows() {
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            int quantity = (int) tableModel.getValueAt(i, 3);
            if (quantity == 0) {
                tableModel.removeRow(i);
            }
        }
        updateRowNumbers();
    }

    private void printBillButtonActionPerformed(ActionEvent evt) {
        removeZeroQuantityRows();
        String guestsBroughtStr = guestsBroughtTextField.getText().trim();
        if (guestsBroughtStr.isEmpty()) {
            guestsBroughtStr = "0";
            guestsBroughtTextField.setText(guestsBroughtStr);
        }
        double total = Double.parseDouble(totalTextField.getText().trim());
        double guestsBrought = Double.parseDouble(guestsBroughtTextField.getText().trim());
      
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(MenuPanel.this, "Empty invoice.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (tableNoTextField.getText() == null || tableNoTextField.getText().isEmpty() ){
            if(guestsBroughtTextField.getText() == null || guestsBroughtTextField.getText().isEmpty()){
                guestsBroughtTextField.setText("0");
                changeTextField.setText("0");
                printBill();
                return;
            } else{
                tableNoTextField.setText("0");
                if(guestsBrought == 0){
                    changeTextField.setText("0");
                } else if (total > guestsBrought) {
                    JOptionPane.showMessageDialog(MenuPanel.this, "The amount given by the customer must be greater than or equal to the value of the order.", "Warning", JOptionPane.WARNING_MESSAGE);
                    setTextField();
                }
                printBill();
                return;
            }
        } else {
            try {     
                if(guestsBrought == 0){
                    changeTextField.setText("0");
                    String textTable = tableNoTextField.getText();
                    if (!isNumericInteger(textTable)) {
                        tableNoTextField.setText("0");
                        JOptionPane.showMessageDialog(MenuPanel.this, "Table number must be an integer. I have set it back to 0.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    printBill();
                    return;
                }
                if (total > guestsBrought) {
                    JOptionPane.showMessageDialog(MenuPanel.this, "The amount given by the customer must be greater than or equal to the value of the order.", "Warning", JOptionPane.WARNING_MESSAGE);
                    guestsBroughtTextField.setText("0");
                    changeTextField.setText("0");
                    return;
                } else {
                    setTextField();
                    printBill();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(MenuPanel.this, "Table numbers & Guests brought must be numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                setTextField();
            }
        }
    }

    private void setTextField(){
        tableNoTextField.setText("0");
        guestsBroughtTextField.setText("0");
        changeTextField.setText("0");
    }
    
    private void printBill(){
        int option = JOptionPane.showConfirmDialog(MenuPanel.this, "Do you want to print invoices?", "Confirm invoice printing", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            String textTable = tableNoTextField.getText();
            String textStaff = staffTextField.getText();
            String note = noteTextField.getText();
            String initialNote = noteTextField.getText();
            String total = totalTextField.getText();
            String guestsBrought = guestsBroughtTextField.getText();
            String change = changeTextField.getText();
            float guestsBroughtAmount = Float.parseFloat(guestsBrought);
            float changeAmount = Float.parseFloat(change);
            
            AccountDAO accountDAO = new AccountDAO();
            Optional<Integer> optionalAccountId = accountDAO.getAccountIdByUsername(textStaff);

            try {
                InvoiceDAO invoiceDAO = new InvoiceDAO();
                Invoice invoice = new Invoice();
                int accountId = optionalAccountId.orElse(0); 
                invoice.setAccountId(accountId);

                float totalAmount = Float.parseFloat(total);
                invoice.setTotal(totalAmount);
                invoice.setDay(new Timestamp(System.currentTimeMillis()));

                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    InvoiceDetail detail = new InvoiceDetail();

                    ProductDaoMenu productDaoMenu = new ProductDaoMenu();
                    String productName = (String) tableModel.getValueAt(i, 1);
                    int productId = productDaoMenu.getProductIdByName(productName);
                    detail.setProductId(productId);

                    String size = (String) tableModel.getValueAt(i, 2);
                    detail.setSize(size);

                    int quantity = (int) tableModel.getValueAt(i, 3);
                    detail.setQuantity(quantity);

                    String sugar = (String) tableModel.getValueAt(i, 4);
                    detail.setSugar(sugar);
                    
                    String productNote = (String) tableModel.getValueAt(i, 6);
                    detail.setNote(productNote);
                    if ("50%".equals(sugar) && productNote != null && !productNote.trim().isEmpty()) {
                        String productNameWithSugar = productName + "-" + size + " 50% đường" + " quantity " + quantity;
                        note += "\n" + productNameWithSugar + " - " + productNote;
                    } else if ("100%".equals(sugar) && productNote != null && !productNote.trim().isEmpty()) {
                        String productNameWithSugar = productName + "-" + size  + " 100% đường"+ " quantity " + quantity;
                        note += "\n" + productNameWithSugar + " - " + productNote;
                    } else if ("50%".equals(sugar)){
                        String productNameWithSugar = productName + "-" + size + " 50% đường"+ " quantity " + quantity;
                        note += "\n" + productNameWithSugar;
                    }

                    if (!textTable.isEmpty()) {
                        float tableNumber = Float.parseFloat(textTable);
                        detail.setTableNumber(tableNumber);
                    } else {
                        detail.setTableNumber(0);
                    }

                    float price = Float.parseFloat(tableModel.getValueAt(i, 5).toString());
                    detail.setPrice(price);

                    invoice.getInvoiceDetails().add(detail);
                }
                
                invoice.setDescription(note);              
                Object[][] products = new Object[tableModel.getRowCount()][7];
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 0; j < 7; j++) { 
                        Object value = tableModel.getValueAt(i, j);
                        if (value == null) {
                            products[i][j] = " "; 
                        } else {
                            products[i][j] = value;
                        }
                    }
                }

                String formattedTotalAmount = String.format("%.1f", totalAmount);
                String formattedGuestsBroughtAmount = String.format("%.1f", guestsBroughtAmount);
                String formattedChangeAmount = String.format("%.1f", changeAmount);
                
                InvoicePDF invoicePdf = new InvoicePDF(textStaff, products, Double.parseDouble(formattedTotalAmount), textTable, initialNote, Float.parseFloat(formattedGuestsBroughtAmount), Float.parseFloat(formattedChangeAmount));
                invoicePdf.generateInvoicePDF();

                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(new File("invoice.pdf"));
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot open PDF file.");
                }

                invoiceDAO.createInvoice(invoice);
                invoiceDAO.close();
            } catch (SQLException | IOException | DocumentException ex) {
                Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            tableModel.setRowCount(0);
            tableNoTextField.setText("");
            noteTextField.setText("");
            guestsBroughtTextField.setText("0");
            changeTextField.setText("0");
            updateProductPanels();
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
                updateProductPanels();
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

    public void setUserName(String userName) {
        this.userName = userName;
        if (staffTextField != null) {
            staffTextField.setText(userName);
        }
    }

    public void refresh(){
        if (tableModel.getRowCount() == 0) {
            updateProductPanels();
            tableNoTextField.setText("");
            noteTextField.setText("");
            guestsBroughtTextField.setText("0");
            changeTextField.setText("0");
        }
    }
    
    private boolean checkvalidate() {
        String textTable = tableNoTextField.getText();
        String textGuestsBrought = guestsBroughtTextField.getText();
        if (!isNumericFloat(textTable) || !isNumericFloat(textGuestsBrought)) {
            JOptionPane.showMessageDialog(null, "Table numbers & Guests brought must be numbers!");
            tableNoTextField.setText("0");
            guestsBroughtTextField.setText("0");
            return false;
        }
        return true;
    }

    private boolean isNumericFloat(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean isNumericInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}