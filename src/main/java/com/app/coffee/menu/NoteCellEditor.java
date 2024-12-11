package com.app.coffee.menu;

import com.app.coffee.virtualKeyBoard.LetterVirtualKeyBoard;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;

public class NoteCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JTextField editorComponent;
    private JLabel dummyComponent;
    private LetterVirtualKeyBoard keyboard;
    private JDialog dialog;
    private String originalValue;

    public NoteCellEditor(JLabel dummyComponent) {
        this.dummyComponent = dummyComponent;
        this.editorComponent = new JTextField();

        this.editorComponent.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                originalValue = editorComponent.getText();
                if (dialog == null || !dialog.isVisible()) {
                    keyboard = new LetterVirtualKeyBoard();
                    keyboard.setText(editorComponent.getText());
                    keyboard.setTitle("Note");

                    dialog = new JDialog((Frame) null, true);
                    dialog.setUndecorated(true);

                    JPanel contentPanel = new JPanel(new BorderLayout());
                    contentPanel.setBorder(new LineBorder(Color.BLACK, 3));
                    contentPanel.add(keyboard, BorderLayout.CENTER);

                    dialog.getContentPane().add(contentPanel);
                    dialog.pack();
                    dialog.setLocation(200, 230);
                    dialog.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            String text = keyboard.getSavedText();
                            editorComponent.setText(text);
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
        return editorComponent.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editorComponent.setText(value != null ? value.toString() : "");
        return editorComponent;
    }
}
