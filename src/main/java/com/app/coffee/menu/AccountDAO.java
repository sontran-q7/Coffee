package com.app.coffee.menu;

import com.app.coffee.product.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import javax.swing.JOptionPane;

public class AccountDAO {

    public Optional<Integer> getAccountIdByUsername(String username) {
        String sql = "SELECT account_id FROM account WHERE username = ?";
        Integer accountId = null;

        try (Connection con = DatabaseConnection.getJDBConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                accountId = rs.getInt("account_id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! " + e.getMessage());
        }
        return Optional.ofNullable(accountId);
    }

   
}

