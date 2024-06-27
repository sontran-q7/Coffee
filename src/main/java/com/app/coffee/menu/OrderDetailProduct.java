/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.menu;

public class OrderDetailProduct {
    private int orderId;
    private int quantity;
    private double total;
    private String orderDescription;
    private int productId;
    private String productName;
    private double price;
    private String productDescription;
    private String size;

    public OrderDetailProduct(int orderId, int quantity, double total, String orderDescription, int productId, String productName, double price, String productDescription, String size) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.total = total;
        this.orderDescription = orderDescription;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
        this.size = size;
    }

    @Override
    public String toString() {
        return "OrderDetailProduct{" +
                "orderId=" + orderId +
                ", quantity=" + quantity +
                ", total=" + total +
                ", orderDescription='" + orderDescription + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productDescription='" + productDescription + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
