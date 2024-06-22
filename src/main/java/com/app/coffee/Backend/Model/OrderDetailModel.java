/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class OrderDetailModel {
    private int order_detail_id;
    private int quantity;
    private float total;
    private String description;
    private Date day;
    private OrderModel order;
    private String username;
    private String product_name;

    public OrderDetailModel(int order_detail_id, int quantity, float total, String description, Date day, OrderModel order, String username, String product_name) {
        this.order_detail_id = order_detail_id;
        this.quantity = quantity;
        this.total = total;
        this.description = description;
        this.day = day;
        this.order = order;
        this.username = username;
        this.product_name = product_name;
    }

      public OrderDetailModel(int order_detail_id, int quantity, float total, String description, Date day) {
        this.order_detail_id = order_detail_id;
        this.quantity = quantity;
        this.total = total;
        this.description = description;
        this.day = day;
      }
    
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public OrderDetailModel(int aInt, int aInt0, float aFloat, String string, java.sql.Date date) {
        this.order_detail_id = aInt;
        this.quantity = aInt0;
        this.total = aFloat;
        this.description = string;
        this.day = date;
        
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public OrderDetailModel() {
        
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
