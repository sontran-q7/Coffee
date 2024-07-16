/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.menu;

import com.app.coffee.product.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InvoiceDAO {
    private Connection connection;

    public InvoiceDAO() throws SQLException {
        connection = DatabaseConnection.getJDBConnection();
    }

    public void createInvoice(Invoice invoice) throws SQLException {
        String sql = "INSERT INTO orders (account_id, total, description, day) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, invoice.getAccountId());
            statement.setFloat(2, invoice.getTotal());
            statement.setString(3, invoice.getDescription());
            statement.setTimestamp(4, invoice.getDay());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating invoice failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int invoiceId = generatedKeys.getInt(1);
                    for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
                        createInvoiceDetail(invoiceId, detail);
                    }
                } else {
                    throw new SQLException("Creating invoice failed, no ID obtained.");
                }
            }
        }
    }

    private void createInvoiceDetail(int invoiceId, InvoiceDetail detail) throws SQLException {
        String sql = "INSERT INTO order_detail (order_id, product_detail_id, quantity, table_number) " +
                     "VALUES (?, (SELECT product_detail_id FROM product_detail WHERE product_id = ? AND size = ?), ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, invoiceId);
            statement.setInt(2, detail.getProductId());
            statement.setString(3, detail.getSize());
            statement.setInt(4, detail.getQuantity());
            statement.setInt(5, detail.getTableNumber());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating invoice detail failed, no rows affected.");
            }
        }
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}

