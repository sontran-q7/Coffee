package com.app.coffee.Backend.Model;

public class OrderModel {
    private int order_id;
    private int order_detail_id;
    private int product_id;
    private int account_id;

    public OrderModel() {
        // Constructor mặc định
    }

    public OrderModel(int order_id, int order_detail_id, int product_id, int account_id) {
        this.order_id = order_id;
        this.order_detail_id = order_detail_id;
        this.product_id = product_id;
        this.account_id = account_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
