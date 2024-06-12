/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;

/**
 *
 * @author phamv
 */
public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter{
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Date date = (Date) value;
            return dateFormatter.format(date);
        }
        return "";
    }
}
