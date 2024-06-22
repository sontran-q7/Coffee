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
                int selectedRow = table.getEditingRow();
                if (selectedRow != -1) { 
                    selectedRow = table.convertRowIndexToModel(selectedRow);
                    Object value = table.getModel().getValueAt(selectedRow, 0); 
                    if (value != null && value instanceof Integer) {
                        int orderDetailId = (Integer) value;
                        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                        OrderDetailModel orderDetailModel = orderDetailDAO.selectById(orderDetailId);
                        if(orderDetailModel != null){
                           DetailForm detailForm = new DetailForm();
                           detailForm.updateDetails(orderDetailModel);
                           detailForm.setVisible(true);
                            fireEditingStopped();
                        }
                        if (bill != null) {
                            bill.refreshListBill();
                        }else {
                            JOptionPane.showMessageDialog(button, "Order detail not found.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(button, "Invalid data type in the table.");
                    }
                } else {
                    JOptionPane.showMessageDialog(button, "No row is selected.");
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
