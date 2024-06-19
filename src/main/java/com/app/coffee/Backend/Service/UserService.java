/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Service;

import com.app.coffee.Backend.DAO.UserDAO;
import com.app.coffee.Backend.Model.Role;
import com.app.coffee.Backend.Model.UsersModel;
import com.app.coffee.Database.PasswordUtils;
import com.app.coffee.Login.CustomDialog;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin
 */
public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }
    public int create(String userName, String email, String password, String confirmPassword, String phone, Role selectedRole) { 
        if (userName.isEmpty()) {
            throw new IllegalArgumentException("User_Name can't be empty!!");
        }

        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email can't be empty!!");
        }
        
        if (phone.length() != 10) {
        throw new IllegalArgumentException("Please enter a phone number with exactly 10 characters!");
        }
        
        Pattern emailPattern = Pattern.compile("^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$");
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {
            throw new IllegalArgumentException("Email Invalid!!");
        }

        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password can't be empty!!");
        }

        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match!!");
        }

        UserDAO userDAO = new UserDAO();
        if (userDAO.checkEmailExists(email)) {
            throw new IllegalArgumentException("Email already exists. Please use a different email.");
        }

        UsersModel newUser = new UsersModel(0, userName, password, Integer.parseInt(phone), selectedRole, 0, email);
        int result = userDAO.Create(newUser); // Assuming `create` method in `UserDAO`

        return result;
    }
    
    
    public boolean updateUser(int currentUserId, String userName, String password, String phone, String email, Role role) {
    try {
        // Check conditions before validation
        if (userName.isEmpty()) {
            displayErrorDialog("Error", "User_Name can't be empty!!");
            return false;
        }

        if (email.isEmpty()) {
            displayErrorDialog("Error", "Email can't be empty!!");
            return false;
        }

        if (phone.length() != 10) {
            displayErrorDialog("Error", "Please enter a phone number with exactly 10 characters!");
            return false;
        }

        if (!isValidEmail(email)) {
            displayErrorDialog("Error", "Email Invalid!!");
            return false;
        }

        if (password.isEmpty()) {
            displayErrorDialog("Error", "Password can't be empty!!");
            return false;
        }

        // Validate data before updating
        validateInput(userName, password, phone, email, role);

        // Create UsersModel object
        UsersModel updatedUser = new UsersModel();
        updatedUser.setAccount_id(currentUserId);
        updatedUser.setUserName(userName);
        updatedUser.setPassword(password);
        updatedUser.setPhone(Integer.parseInt(phone));
        updatedUser.setEmail(email);
        updatedUser.setRole(role);

        // Call DAO to update user
        int result = userDAO.Update(updatedUser);

        if (result > 0) {
            displaySuccessDialog("Success", "User updated successfully!");
            return true;
        } else {
            displayErrorDialog("Error", "Failed to update user!");
            return false;
        }
    } catch (IllegalArgumentException ex) {
        // IllegalArgumentException from validateInput
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        displayErrorDialog("Error", ex.getMessage());
        return false;
    } catch (SQLException | NoSuchAlgorithmException ex) {
        // Other exceptions
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        displayErrorDialog("Error", "An error occurred during update.");
        return false;
    }
}

private void validateInput(String userName, String password, String phone, String email, Role role) throws SQLException, NoSuchAlgorithmException {
    // Validate user input
    if (userName.isEmpty()) {
        throw new IllegalArgumentException("User_Name can't be empty!!");
    }

    if (email.isEmpty()) {
        throw new IllegalArgumentException("Email can't be empty!!");
    }

    if (phone.length() != 10) {
        throw new IllegalArgumentException("Please enter a phone number with exactly 10 characters!");
    }

    if (!isValidEmail(email)) {
        throw new IllegalArgumentException("Email Invalid!!");
    }

    if (password.isEmpty()) {
        throw new IllegalArgumentException("Password can't be empty!!");
    }

    // You can add more validations as needed

    // Hash password
    String hashedPassword = PasswordUtils.hashPassword(password);
}

    private boolean isValidEmail(String email) {
        Pattern emailPattern = Pattern.compile("^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$");
        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.matches();
    }

    private void displayErrorDialog(String title, String message) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(new JFrame()); 
        CustomDialog dialog = new CustomDialog(frame, title, message);
    }

    private void displaySuccessDialog(String title, String message) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(new JFrame()); 
        CustomDialog dialog = new CustomDialog(frame, title, message);
    }
    
    
}
    

