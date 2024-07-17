/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

import com.app.coffee.category.Category;
import java.time.LocalDateTime;

public class Product {

    private Integer product_id;
    private Category category;
    private String product_name;
    private String image;
    private String description;
    private boolean status;
    private LocalDateTime created_at;
    private LocalDateTime update_at;
    private ProductDetail productDetail;

    public Product() {
    }

    public Product(Integer product_id, Category category, String product_name, String image, String description) {
        this.product_id = product_id;
        this.category = category;
        this.product_name = product_name;
        this.image = image;
        this.description = description;
    }
    
    public Product(Integer product_id, Category category, String product_name, String image, String description, ProductDetail productDetail) {
        this.product_id = product_id;
        this.category = category;
        this.product_name = product_name;
        this.image = image;
        this.description = description;
        this.productDetail = productDetail;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

}
