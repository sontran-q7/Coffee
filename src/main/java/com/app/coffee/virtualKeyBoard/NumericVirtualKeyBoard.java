package com.app.coffee.virtualKeyBoard;

import com.app.coffee.menu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumericVirtualKeyBoard extends JPanel implements ActionListener {
    private String[] keysRow1 = {"1", "2", "3"};
    private String[] keysRow2 = {"4", "5", "6"};
    private String[] keysRow3 = {"7", "8", "9"};
    private String[] keysRow4 = {".", "0", "Backspace"};

    private JButton[] buttonList;
    private String buffer = "";
    private JTextField text;
    private JButton backspace, dot, zero, backButton, saveButton;
    private String savedText = "";
    private String initialText = "";
    private JLabel titleLabel;
    
    public NumericVirtualKeyBoard() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 300));
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("", SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(0, 50));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        text = new JTextField(30);
        text.setPreferredSize(new Dimension(0, 50));
        text.setFont(new Font("Arial", Font.PLAIN, 18));
        text.setMargin(new Insets(0, 10, 0, 0));

        backButton = new JButton("BACK");
        backButton.setBackground(new Color(51, 51, 51));
        backButton.setForeground(new Color(255, 102, 0));
        backButton.setPreferredSize(new Dimension(80, 50));
        backButton.addActionListener(this);

        saveButton = new JButton("SAVE");
        saveButton.setBackground(new Color(255, 102, 0));
        saveButton.setForeground(new Color(255, 255, 255));
        saveButton.setPreferredSize(new Dimension(80, 50));
        saveButton.addActionListener(this);

        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(text, BorderLayout.CENTER);
        topPanel.add(saveButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        JPanel pane = new JPanel();
        pane.setLayout(null);

        int totalButtons = keysRow1.length + keysRow2.length + keysRow3.length + keysRow4.length;
        buttonList = new JButton[totalButtons];
        int index = 0;

        int panelWidth = 300;
        int y = 0;

        createRow(keysRow1, pane, panelWidth, y, index);
        index += keysRow1.length;
        y += 50;

        createRow(keysRow2, pane, panelWidth, y, index);
        index += keysRow2.length;
        y += 50;

        createRow(keysRow3, pane, panelWidth, y, index);
        index += keysRow3.length;
        y += 50;

        createRow(keysRow4, pane, panelWidth, y, index);

        dot = buttonList[totalButtons - 3];
        zero = buttonList[totalButtons - 2];
        backspace = buttonList[totalButtons - 1];

        add(pane, BorderLayout.CENTER);
    }

    public void createRow(String[] keys, JPanel pane, int panelWidth, int y, int startIndex) {
        int numButtons = keys.length;
        int buttonWidth = panelWidth / numButtons;
        for (int i = 0; i < numButtons; i++) {
            buttonList[startIndex + i] = new JButton(keys[i]);
            buttonList[startIndex + i].setBounds(i * buttonWidth, y, buttonWidth, 50);
            buttonList[startIndex + i].setBackground(Color.WHITE);
            buttonList[startIndex + i].setForeground(Color.BLACK);
            buttonList[startIndex + i].addActionListener(this);
            pane.add(buttonList[startIndex + i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backspace) {
            if (!buffer.isEmpty()) {
                buffer = buffer.substring(0, buffer.length() - 1);
                text.setText(buffer);
            }
        } else if (e.getSource() == backButton) {
            savedText = getInitialText();
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose();
            }
        } else if (e.getSource() == saveButton) {
            savedText = text.getText();
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose();
            }
        } else {
            for (JButton button : buttonList) {
                if (e.getSource() == button) {
                    String buttonText = button.getText();
                    if (buttonText.equals("Backspace")) {
                        buffer = "";
                    } else {
                        buffer += buttonText;
                    }
                    text.setText(buffer);
                    break;
                }
            }
        }
    }

    public void closeVirtualKeyboard() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
        }
    }
    
    public void setText(String text) {
        this.buffer = text;
        this.text.setText(text);
        this.initialText = text;  
    }

    public String getInitialText() {
        return this.initialText;  
    }

    public String getSavedText() {
        return this.savedText;
    }
    
    public void setTitle(String title) {
        this.titleLabel.setText(title);
    }
}
