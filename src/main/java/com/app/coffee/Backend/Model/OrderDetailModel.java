/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Model;

import java.util.Date;
import java.util.List;

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
    private float price;
    private String size;
    private String email;
    private int order_id;
    private List<OrderItemModel> orderItems;

       public OrderDetailModel(int order_id, int order_detail_id, int quantity, float total, String description, Date day) {
        this.order_id = order_id;
        this.order_detail_id = order_detail_id;
        this.quantity = quantity;
        this.total = total;
        this.description = description;
        this.day = day;
    }
       public List<OrderItemModel> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemModel> orderItems) {
        this.orderItems = orderItems;
    }
    
//    public OrderDetailModel(int order_detail_id, int order_id, int quantity, float total, String description, Date day, OrderModel order, String username, String product_name,String size, String email, float price) {
//        this.order_detail_id = order_detail_id;
//        this.quantity = quantity;
//        this.total = total;
//        this.description = description;
//        this.day = day;
//        this.order = order;
//        this.username = username;
//        this.product_name = product_name;
//        this.email= email;
//        this.price = price;
//        this.size = size;
//        this.order_id = order_id;
//    }
//    
//    public OrderDetailModel(int order_detail_id, int quantity, float total, String description, Date day, int order_id, String username, String email) {
//        this.order_detail_id = order_detail_id;
//        this.quantity = quantity;
//        this.total = total;
//        this.description = description;
//        this.day = day;
//        this.order_id = order_id;
//        this.username = username;
//        this.email = email;
//    }
//
//    public OrderDetailModel(int aInt, int aInt0, int aInt1, float aFloat, String string, java.sql.Date date) {
//         
//    }
//
//    
//    public OrderDetailModel(int order_detail_id, int quantity, float total, String description, Date day, OrderModel order, String username, String product_name, float price, String size, String email) {
//        this.order_detail_id = order_detail_id;
//        this.quantity = quantity;
//        this.total = total;
//        this.description = description;
//        this.day = day;
//        this.order = order;
//        this.username = username;
//        this.product_name = product_name;
//        this.price = price;
//        this.size = size;
//        this.email = email;
//    }

  
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//      public OrderDetailModel(int order_detail_id, int quantity, float total, String description, Date day) {
//        this.order_detail_id = order_detail_id;
//        this.quantity = quantity;
//        this.total = total;
//        this.description = description;
//        this.day = day;
//      }
    
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

//    public OrderDetailModel(int aInt, int aInt0, float aFloat, String string, java.sql.Date date) {
//        this.order_detail_id = aInt;
//        this.quantity = aInt0;
//        this.total = aFloat;
//        this.description = string;
//        this.day = date;
//        
//    }

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
