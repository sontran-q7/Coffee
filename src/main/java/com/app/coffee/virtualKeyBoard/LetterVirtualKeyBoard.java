package com.app.coffee.virtualKeyBoard;

import com.app.coffee.menu.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LetterVirtualKeyBoard extends JPanel implements ActionListener {
    private String[] keysRow1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private String[] keysRow2 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"};
    private String[] keysRow3 = {"A", "S", "D", "F", "G", "H", "J", "K", "L", ";"};
    private String[] keysRow4 = {"Z", "X", "C", "V", "B", "N", "M", ",", ".", "/"};
    private String[] keysRow5 = {"Shift", "Caps", "Space", "Backspace", "Clear"};

    private JButton[] buttonList;
    private String buffer = "";
    private JTextField text;
    private JButton backspace, spaceBar, shift, capsLock, backButton, saveButton, clearButton;
    private boolean isShift = false;
    private boolean isCapsLock = false;
    private String savedText = "";
    private String initialText = ""; 
    private JLabel titleLabel;
    
    public LetterVirtualKeyBoard() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 350));
        
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
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.addActionListener(this);

        saveButton = new JButton("SAVE");
        saveButton.setBackground(new Color(255, 102, 0));
        saveButton.setForeground(new Color(255, 255, 255));
        saveButton.setPreferredSize(new Dimension(100, 50));
        saveButton.addActionListener(this);

        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(text, BorderLayout.CENTER);
        topPanel.add(saveButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        JPanel pane = new JPanel();
        pane.setLayout(null);

        int totalButtons = keysRow1.length + keysRow2.length + keysRow3.length + keysRow4.length + keysRow5.length;
        buttonList = new JButton[totalButtons];
        int index = 0;

        int panelWidth = 900;
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
        index += keysRow4.length;
        y += 50;

        createRow(keysRow5, pane, panelWidth, y, index);

        shift = buttonList[totalButtons - 5];
        capsLock = buttonList[totalButtons - 4];
        spaceBar = buttonList[totalButtons - 3];
        backspace = buttonList[totalButtons - 2];
        clearButton = buttonList[totalButtons - 1];

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
        } else if (e.getSource() == spaceBar) {
            buffer += " ";
            text.setText(buffer);
        } else if (e.getSource() == shift) {
            isShift = !isShift;
            updateKeys();
        } else if (e.getSource() == capsLock) {
            isCapsLock = !isCapsLock;
            updateKeys();
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
        } else if (e.getSource() == clearButton) {
            buffer = "";
            text.setText(buffer);
        } else {
            for (JButton button : buttonList) {
                if (e.getSource() == button) {
                    String buttonText = button.getText();
                    if (buttonText.equals("Backspace")) {
                        if (!buffer.isEmpty()) {
                            buffer = buffer.substring(0, buffer.length() - 1);
                        }
                    } else if (buttonText.equals("Space")) {
                        buffer += " ";
                    } else if (buttonText.equals("Shift")) {
                        isShift = !isShift;
                        updateKeys();
                    } else if (buttonText.equals("Caps")) {
                        isCapsLock = !isCapsLock;
                        updateKeys();
                    } else if (buttonText.equals("Clear")) {
                        buffer = "";
                    } else {
                        char c = buttonText.charAt(0);
                        if (isShift || isCapsLock) {
                            c = Character.toUpperCase(c);
                            isShift = false;
                            updateKeys();
                        } else {
                            c = Character.toLowerCase(c);
                        }
                        buffer += c;
                    }
                    text.setText(buffer);
                    break;
                }
            }
        }
    }

    public void updateKeys() {
        for (JButton button : buttonList) {
            String buttonText = button.getText();
            if (buttonText.length() == 1) {
                char c = buttonText.charAt(0);
                if (isShift || isCapsLock) {
                    button.setText("" + Character.toUpperCase(c));
                } else {
                    button.setText("" + Character.toLowerCase(c));
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
