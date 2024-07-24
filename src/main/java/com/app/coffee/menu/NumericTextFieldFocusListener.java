package com.app.coffee.menu;

import com.app.coffee.virtualKeyBoard.NumericVirtualKeyBoard;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class NumericTextFieldFocusListener extends FocusAdapter {
    private final Component dummyComponent;
    private boolean keyboardClosed = true;

    public NumericTextFieldFocusListener(Component dummyComponent) {
        this.dummyComponent = dummyComponent;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (keyboardClosed) {
            keyboardClosed = false;
            JTextField source = (JTextField) e.getSource();
            NumericVirtualKeyBoard keyboard = new NumericVirtualKeyBoard();
            keyboard.setText(source.getText());
            keyboard.setTitle(source.getName());

            JDialog dialog = new JDialog((Frame) null, true);
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
                    source.setText(keyboard.getSavedText());
                    SwingUtilities.invokeLater(() -> {
                        dummyComponent.requestFocusInWindow();
                        keyboardClosed = true;
                    });
                }
            });
            dialog.setVisible(true);
        }
    }
}
