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
    private int table_number;
    private int status;
    private List<ProductDetailModel> productDetails;

    public OrderDetailModel() {
        // Constructor mặc định
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

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ProductDetailModel> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetailModel> productDetails) {
        this.productDetails = productDetails;
    }
}
