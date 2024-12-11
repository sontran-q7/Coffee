/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.menu;

import com.app.coffee.virtualKeyBoard.NumericVirtualKeyBoard;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;

public class QuantityCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JTextField editorComponent;
    private JLabel dummyComponent;
    private NumericVirtualKeyBoard keyboard;
    private JDialog dialog;
    private String originalValue;
    
    public QuantityCellEditor(JLabel dummyComponent) {
        this.dummyComponent = dummyComponent;
        this.editorComponent = new JTextField();
        
        this.editorComponent.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                originalValue = editorComponent.getText();
                if (dialog == null || !dialog.isVisible()) {
                    keyboard = new NumericVirtualKeyBoard();
                    keyboard.setText(editorComponent.getText());
                    keyboard.setTitle("Quantity");

                    dialog = new JDialog((Frame) null, true);
                    dialog.setUndecorated(true);

                    JPanel contentPanel = new JPanel(new BorderLayout());
                    contentPanel.setBorder(new LineBorder(Color.BLACK, 3));
                    contentPanel.add(keyboard, BorderLayout.CENTER);

                    dialog.getContentPane().add(contentPanel);
                    dialog.pack();
                    dialog.setLocation(620, 300);
                    dialog.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            String text = keyboard.getSavedText();
                            try {
                                int quantity = Integer.parseInt(text);
                                editorComponent.setText(String.valueOf(quantity));
                            } catch (NumberFormatException ex) {
                                editorComponent.setText(originalValue);
                            }
                            dummyComponent.requestFocusInWindow();
                            stopCellEditing();
                        }
                    });
                    dialog.setVisible(true);
                }
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return Integer.parseInt(editorComponent.getText());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editorComponent.setText(value != null ? value.toString() : "");
        return editorComponent;
    }
}

