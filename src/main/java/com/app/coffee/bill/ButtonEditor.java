/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.bill;

/**
 *
 * @author Admin
 */
import com.app.coffee.Backend.DAO.OrderDetailDAO;
import com.app.coffee.Backend.Model.OrderDetailModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JOptionPane;

public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;
    private Bill bill;
    private DetailForm detailForm;
    
    private Object[] rowData;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setPreferredSize(new java.awt.Dimension(20, 20));
        button.setBackground(Color.red);
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
         @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
            int orderDetailId = (Integer) table.getModel().getValueAt(selectedRow, 0);

            // Assuming OrderDetailDAO and OrderDetailModel are properly defined
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            OrderDetailModel orderDetailModel = orderDetailDAO.selectById(orderDetailId);

            if (orderDetailModel != null) {
                DetailForm detailForm = new DetailForm(); // Create DetailForm instance
                detailForm.updateDetails(orderDetailModel); // Update details in the form

                JOptionPane.showMessageDialog(button, detailForm, "Detail Form", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(button, "Order detail not found.");
            }

            if (bill != null) {
                bill.refreshListBill(); // Refresh the bill if necessary
            }
        }
        });
    }
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        label = "Detail"; 
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            isPushed = false;
            return label;
        } else {
            return ""; 
        }
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
