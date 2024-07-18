/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.DAO;

import com.app.coffee.Backend.Connect.ConnectionCoffee;
import com.app.coffee.Backend.Model.OrderDetailModel;

import com.app.coffee.Backend.Model.OrderModel;
import com.app.coffee.Backend.Model.ProductDetailModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author Admin
 */
public class OrderDetailDAO implements DAOInterface<OrderDetailModel>{

     public static OrderDetailDAO getInstance() {
        return new OrderDetailDAO();
    }
    @Override
    public int Create(OrderDetailModel t) {
        
        return 0;
    }

    @Override
    public int Update(OrderDetailModel t) {
        return 0;
    }

    @Override
    public int Delete(OrderDetailModel t) {
        return 0;
    }

    /**
     *
     * @return
     */
   
    public ArrayList<OrderModel> selectAll1Bill() {
        ArrayList<OrderModel> ListBill = new ArrayList<>();
        try (Connection conn = ConnectionCoffee.getConnection()) {
            String sql = "SELECT o.order_id, o.account_id, o.total, o.description AS order_description, o.created_at, " +
                         "a.username AS account_username, a.email AS account_email " +
                         "FROM orders o " +
                         "LEFT JOIN account a ON o.account_id = a.account_id";

            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    OrderModel orderModel = new OrderModel();
                    orderModel.setOrder_id(rs.getInt("order_id"));
                    orderModel.setAccount_id(rs.getInt("account_id"));
                    orderModel.setTotal(rs.getFloat("total"));
                    orderModel.setDescription(rs.getString("order_description"));
                    Timestamp timestamp = rs.getTimestamp("created_at");
                    if (timestamp != null) {
                        orderModel.setDay(timestamp.toLocalDateTime());
                    }
                    orderModel.setUsername(rs.getString("account_username"));
                    orderModel.setEmail(rs.getString("account_email"));

                    ListBill.add(orderModel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return ListBill;
}

    public ArrayList<OrderModel> selectByDateRange(LocalDateTime  fromDate, LocalDateTime  toDate) {
    ArrayList<OrderModel> list = new ArrayList<>();
    try (Connection conn = ConnectionCoffee.getConnection()) {
        String sql = "SELECT o.order_id, o.account_id, o.total, o.description AS order_description, o.created_at, " +
                     "a.username AS account_username, a.email AS account_email " +
                     "FROM orders o " +
                     "LEFT JOIN account a ON o.account_id = a.account_id " +
                     "WHERE o.created_at >= ? AND o.created_at < ?";
             LocalDateTime endOfToDate = toDate.plusDays(1).toLocalDate().atStartOfDay();         
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.valueOf(fromDate));
            stmt.setTimestamp(2, Timestamp.valueOf(endOfToDate));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    OrderModel orderModel = new OrderModel();
                    orderModel.setOrder_id(rs.getInt("order_id"));
                    orderModel.setAccount_id(rs.getInt("account_id"));
                    orderModel.setTotal(rs.getFloat("total"));
                    orderModel.setDescription(rs.getString("order_description"));
                    Timestamp timestamp = rs.getTimestamp("created_at");
                    if (timestamp != null) {
                        orderModel.setDay(timestamp.toLocalDateTime());
                    }
                    orderModel.setUsername(rs.getString("account_username"));
                    orderModel.setEmail(rs.getString("account_email"));

                    list.add(orderModel);
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return list;
}

    public OrderModel  selectById(int orderId) {
        OrderModel orderModel = null;
        String sql = "SELECT o.order_id, o.account_id, o.total, o.description AS order_description, o.created_at, " +
                 "od.order_detail_id, od.product_detail_id, od.quantity, od.table_number, od.status AS order_detail_status, " +
                 "a.username AS account_username, a.email AS account_email, " +
                 "pd.size, pd.price, " +
                 "p.product_name " +
                 "FROM orders o " +
                 "LEFT JOIN order_detail od ON o.order_id = od.order_id " +
                 "LEFT JOIN account a ON o.account_id = a.account_id " +
                 "LEFT JOIN product_detail pd ON od.product_detail_id = pd.product_detail_id " +
                 "LEFT JOIN product p ON pd.product_id = p.product_id " +
                 "WHERE o.order_id = ?";

    try (Connection conn = ConnectionCoffee.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, orderId);
        try (ResultSet rs = ps.executeQuery()) {
            Map<Integer, OrderDetailModel> orderDetailsMap = new HashMap<>();

            while (rs.next()) {
                if (orderModel == null) {
                    orderModel = new OrderModel();
                    orderModel.setOrder_id(rs.getInt("order_id"));
                    orderModel.setAccount_id(rs.getInt("account_id"));
                    orderModel.setTotal(rs.getFloat("total"));
                    orderModel.setDescription(rs.getString("order_description"));
                    Timestamp timestamp = rs.getTimestamp("created_at");
                    if (timestamp != null) {
                        orderModel.setDay(timestamp.toLocalDateTime());
                    }
                    orderModel.setUsername(rs.getString("account_username"));
                    orderModel.setEmail(rs.getString("account_email"));
                }

                int orderDetailId = rs.getInt("order_detail_id");
                OrderDetailModel orderDetail = orderDetailsMap.get(orderDetailId);
                if (orderDetail == null) {
                    orderDetail = new OrderDetailModel();
                    orderDetail.setOrder_detail_id(orderDetailId);
                    orderDetail.setQuantity(rs.getInt("quantity"));
                    orderDetail.setTable_number(rs.getInt("table_number"));
                    orderDetail.setStatus(rs.getInt("order_detail_status"));
                    orderDetail.setProductDetails(new ArrayList<>());
                    orderDetailsMap.put(orderDetailId, orderDetail);
                }

                ProductDetailModel productDetail = new ProductDetailModel();
                productDetail.setProduct_detail_id(rs.getInt("product_detail_id"));
                productDetail.setSize(rs.getString("size"));
                productDetail.setPrice(rs.getFloat("price"));
                
                productDetail.setProduct_name(rs.getString("product_name"));

                orderDetail.getProductDetails().add(productDetail);
            }

            if (orderModel != null) {
                orderModel.setOrderDetails(new ArrayList<>(orderDetailsMap.values()));
            }
        }
    } catch (SQLException e) {
        System.out.println("SQL Error: " + e.getMessage());
    }
    return orderModel;
}
    
    
    public ArrayList<OrderModel> selectByUsernameAndDate(String username, LocalDateTime fromDate, LocalDateTime toDate) {
    ArrayList<OrderModel> list = new ArrayList<>();
    try (Connection conn = ConnectionCoffee.getConnection()) {
        String sql = "SELECT o.order_id, o.total, o.description AS order_description, o.created_at " +
             "FROM orders o " +
             "LEFT JOIN account a ON o.account_id = a.account_id " +
             "WHERE a.username = ? AND o.created_at >= ? AND o.created_at <= ?";
                   
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setTimestamp(2, Timestamp.valueOf(fromDate));
            stmt.setTimestamp(3, Timestamp.valueOf(toDate.with(LocalTime.of(23, 59, 59))));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    OrderModel orderModel = new OrderModel();
                    orderModel.setOrder_id(rs.getInt("order_id"));
                    orderModel.setTotal(rs.getFloat("total"));
                    orderModel.setDescription(rs.getString("order_description"));
                    Timestamp timestamp = rs.getTimestamp("created_at");
                    if (timestamp != null) {
                        orderModel.setDay(timestamp.toLocalDateTime());
                    }

                    list.add(orderModel);
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return list;
}
    
    public ArrayList<OrderModel> selectByUsername(String username) {
    ArrayList<OrderModel> list = new ArrayList<>();
    try (Connection conn = ConnectionCoffee.getConnection()) {
        String sql = "SELECT o.order_id, o.total, o.description AS order_description, o.created_at " +
                     "FROM orders o " +
                     "LEFT JOIN account a ON o.account_id = a.account_id " +
                     "WHERE a.username = ?";
                   
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    OrderModel orderModel = new OrderModel();
                    orderModel.setOrder_id(rs.getInt("order_id"));
                    orderModel.setTotal(rs.getFloat("total"));
                    orderModel.setDescription(rs.getString("order_description"));
                    Timestamp timestamp = rs.getTimestamp("created_at");
                    if (timestamp != null) {
                        orderModel.setDay(timestamp.toLocalDateTime());
                    }

                    list.add(orderModel);
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return list;
}
    
    
    @Override
    public OrderDetailModel selectById(OrderDetailModel t) {
        OrderDetailModel orderDetailModel = null;
        return orderDetailModel;
    }
    
    @Override
    public ArrayList<OrderDetailModel> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteAccount(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean restoreAccount(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OrderDetailModel> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
