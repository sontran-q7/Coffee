package com.app.coffee.menu;

import com.app.coffee.virtualKeyBoard.LetterVirtualKeyBoard;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class TextFieldFocusListener extends FocusAdapter {
    private final Component dummyComponent;
    private boolean keyboardClosed = true;

    public TextFieldFocusListener(Component dummyComponent) {
        this.dummyComponent = dummyComponent;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (keyboardClosed) {
            keyboardClosed = false;
            JTextField source = (JTextField) e.getSource();
            LetterVirtualKeyBoard keyboard = new LetterVirtualKeyBoard();
            keyboard.setText(source.getText());
            keyboard.setTitle(source.getName());

            JDialog dialog = new JDialog((Frame) null, true);
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
