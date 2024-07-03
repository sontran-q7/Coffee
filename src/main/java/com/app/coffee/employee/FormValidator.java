package com.app.coffee.employee;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class FormValidator {

    public static boolean validateForm(String fullName, String position, String phone, String email, String password, String confirmPassword) {
        if (fullName.isEmpty() || position.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!phone.matches("^0\\d{8,}$")) {
            JOptionPane.showMessageDialog(null, "The phone number always starts with 0 and must have at least 8 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static boolean validateEditForm(String fullName, String position, String phone, String email, String password, String confirmPassword) {
        if (fullName.isEmpty() || position.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!phone.matches("^\\d{8,}$")) {
            JOptionPane.showMessageDialog(null, "Phone number must have at least 8 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.isEmpty() || !confirmPassword.isEmpty()) {
            if (password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the password fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
