/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

/**
 *
 * @author ADMIN
 */
public class Order {

    private int order_detail_id;
    
    private int order_id;

    public Order(int order_detail_id, int order_id) {
        this.order_detail_id = order_detail_id;
        this.order_id = order_id;
    }

    public Order() {
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    
    
}
