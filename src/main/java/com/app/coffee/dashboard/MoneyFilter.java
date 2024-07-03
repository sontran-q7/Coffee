/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.dashboard;

/**
 *
 * @author anhso
 */
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MoneyFilter extends DocumentFilter {
    private static final String NUMBER_REGEX = "\\d*\\.?\\d*";

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, string);

        if (sb.toString().matches(NUMBER_REGEX)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.replace(offset, offset + length, text);

        if (sb.toString().matches(NUMBER_REGEX)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.delete(offset, offset + length);

        if (sb.toString().matches(NUMBER_REGEX)) {
            super.remove(fb, offset, length);
        }
    }
}

