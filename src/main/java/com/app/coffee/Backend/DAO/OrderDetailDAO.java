/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.DAO;

import com.app.coffee.Backend.Connect.ConnectionCoffee;
import com.app.coffee.Backend.Model.OrderDetailModel;
import com.app.coffee.Backend.Model.OrderModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
     @Override
     public ArrayList<OrderDetailModel> selectAll() {
        ArrayList<OrderDetailModel> ListBill = new ArrayList<>();
         try (Connection conn = ConnectionCoffee.getConnection()){
             String sql = "SELECT order_detail_id, quantity, total, description, day FROM order_detail";
                     
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                OrderDetailModel orderDetailModel = new OrderDetailModel(
                    rs.getInt("order_detail_id"),
                    rs.getInt("quantity"),
                    rs.getFloat("total"),
                    rs.getString("description"),
                    rs.getDate("day")
                );
                ListBill.add(orderDetailModel);
             }
             rs.close();
             ps.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         
        return ListBill;
    }

    public ArrayList<OrderDetailModel> selectByDateRange(Date fromDate, Date toDate) {
        ArrayList<OrderDetailModel> list = new ArrayList<>();
        try (Connection conn = ConnectionCoffee.getConnection()) {
            String sql = "SELECT * FROM order_detail WHERE day >= ? AND day <= ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDate(1, new java.sql.Date(fromDate.getTime()));
                stmt.setDate(2, new java.sql.Date(toDate.getTime()));
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        OrderDetailModel orderDetail = new OrderDetailModel();
                        
                        orderDetail.setOrder_detail_id(rs.getInt("order_detail_id"));
                        orderDetail.setQuantity(rs.getInt("quantity"));
                        orderDetail.setTotal(rs.getFloat("total"));
                        orderDetail.setDescription(rs.getString("description"));
                        orderDetail.setDay(rs.getDate("day"));
                        list.add(orderDetail);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public OrderDetailModel selectById(int orderDetailId) {
        OrderDetailModel orderDetailModel = null;
        String sql = "SELECT o.order_id, o.order_detail_id, o.account_id, " +
             "od.quantity, od.total, od.description, od.day, " +
//             "a.username, d.product_name " +   
             "a.username " +
             "FROM `order` o " +
             "JOIN `order_detail` od ON o.order_detail_id = od.order_detail_id " +
             "JOIN `account` a ON o.account_id = a.account_id " +
//             "JOIN `product` d ON o.product_id = d.product_id " +
             "WHERE o.order_id = ?";
                
        try (Connection conn = ConnectionCoffee.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, orderDetailId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    OrderModel order = new OrderModel(orderDetailId, orderDetailId, orderDetailId, orderDetailId);
                    order.setOrder_id(rs.getInt("order_id"));
                    order.setAccount_id(rs.getInt("account_id"));
                    order.setOrder_detail_id(rs.getInt("order_detail_id"));
                    
                    orderDetailModel = new OrderDetailModel(
                    rs.getInt("order_detail_id"),
                    rs.getInt("quantity"),
                    rs.getFloat("total"),
                    rs.getString("description"),
                    rs.getDate("day")              
                );
                    orderDetailModel.setOrder(order); 
                    orderDetailModel.setUsername(rs.getString("username"));    
//                    orderDetailModel.setProduct_name(rs.getString("product_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetailModel;
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
 
}
