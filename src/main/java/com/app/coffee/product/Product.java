/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

public class Product {

    private int product_id;
    private String image; // Sử dụng byte array để lưu trữ dữ liệu hình ảnh (blob) (string image)
    private int category_id;
    private String product_name;
    private String description;
    private String size;
    private int price;
    private String status;

    // Constructor không tham số
    public Product(String product_name1, String size1, double parseDouble) {

    }


    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product(int product_id, String image, int category_id, String product_name, String description, String size, int price, String status) {
        this.product_id = product_id;
        this.image = image;
        this.category_id = category_id;
        this.product_name = product_name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.status = status;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getImage() {
        return image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public int getCategoryId() {
        return category_id; // assuming category_id is a string representation of an integer
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", image=" + image + ", category_id=" + category_id + ", product_name=" + product_name + ", description=" + description + ", size=" + size + ", price=" + price + ", status=" + status + '}';
    }

}
