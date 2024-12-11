/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.dashboard;

import com.app.coffee.Backend.DAO.OrderDetailDAO;
import com.app.coffee.Backend.Model.OrderModel;
import com.app.coffee.bill.Bill;
import com.app.coffee.bill.DetailForm;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;

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
            int orderId = (Integer) table.getModel().getValueAt(selectedRow, 1);
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            OrderModel ordermodel = orderDetailDAO.selectById(orderId);

            if (ordermodel != null) {
                DetailForm detailForm = new DetailForm(); 
                detailForm.updateDetails(ordermodel); 

                JDialog dialog = new JDialog((Frame) null, "Detail Form", true);
                dialog.getContentPane().add(detailForm);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(button, "Order detail not found.");
            }

            if (bill != null) {
                bill.refreshListBill(); 
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
        label =  "Detail" ;
        button.setText(label);
        isPushed = true;
        return button;
    }

     @Override
    public Object getCellEditorValue() {
        return label;
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
