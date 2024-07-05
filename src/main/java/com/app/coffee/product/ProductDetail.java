/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

import java.time.LocalDateTime;

/**
 *
 * @author anhso
 */
public class ProductDetail {

    private int product_detail_id;
    private Product product;
    private String size;
    private Integer price;
    private boolean status;
    private LocalDateTime created_at;
    private LocalDateTime update_at;

    public ProductDetail(int product_detail_id, Product product, String size, Integer price, boolean status, LocalDateTime created_at, LocalDateTime update_at) {
        this.product_detail_id = product_detail_id;
        this.product = product;
        this.size = size;
        this.price = price;
        this.status = status;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public ProductDetail(Product product, String size, Integer price) {
        this.product = product;
        this.size = size;
        this.price = price;
    }

    public ProductDetail(String size, Integer price) {
        this.size = size;
        this.price = price;
    }

    public ProductDetail() {
    }

    public int getProduct_detail_id() {
        return product_detail_id;
    }

    public void setProduct_detail_id(int product_detail_id) {
        this.product_detail_id = product_detail_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "ProductDetail{" + "product_detail_id=" + product_detail_id + ", product=" + product + ", size=" + size + ", price=" + price + ", status=" + status + ", created_at=" + created_at + ", update_at=" + update_at + '}';
    }

}
