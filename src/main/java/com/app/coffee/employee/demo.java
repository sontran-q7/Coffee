/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.employee;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

/**
 *
 * @author phamv
 */
public class demo extends JFrame{
    public demo() {
        setTitle("Demo Application");

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        //setSize(958, 527);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Center the frame
        setLocationRelativeTo(null);

        // Create an instance of demo panel
        EmployeeManager panel = new EmployeeManager();
        //StaffSchedule panel = new StaffSchedule();
        //ReturnAccount panel = new ReturnAccount();
        // Add the demo panel to the frame
        add(panel);
    }
    
    public static void main(String[] args) {
        //FlatLaf.registerCustomDefaultsSource("com.app.coffee.employee");
        //FlatMacDarkLaf.setup();
        //FlatIntelliJLaf.setup();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                demo frame = new demo();
                frame.setVisible(true);
            }
        });
    }
}
