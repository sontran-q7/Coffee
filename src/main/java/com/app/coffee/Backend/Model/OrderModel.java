package com.app.coffee.Backend.Model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class OrderModel {
    private int order_id;
    private int account_id;
    private float total;
    private String description;
    private LocalDateTime  day;
    private String username;
    private String email;
    private List<OrderDetailModel> orderDetails;

    public OrderModel(int order_id, int account_id, float total, String description, LocalDateTime  day, String username, String email, List<OrderDetailModel> orderDetails) {
        this.order_id = order_id;
        this.account_id = account_id;
        this.total = total;
        this.description = description;
        this.day = day;
        this.username = username;
        this.email = email;
        this.orderDetails = orderDetails;
    }


    public OrderModel() {
        // Constructor mặc định
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

      public List<OrderDetailModel> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailModel> orderDetails) {
        this.orderDetails = orderDetails;
    }    

    public String getTable_number() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
