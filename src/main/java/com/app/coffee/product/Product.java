/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Product {
    
    private String ID;
//    private BufferedImage image; // kiểu dữ liệu phù hợp để lưu đường dẫn hoặc thông tin hình ảnh
    private String image;
    private String category;
    private String product;
    private String size;
    private String price;

    public Product(String ID, String image, String category, String product, String size, String price) {
        this.ID = ID;
        this.image = image;
        this.category = category;
        this.product = product;
        this.size = size;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getProduct() {
        return product;
    }

    public String getSize() {
        return size;
    }
//    public String getSize() {
//        // Trả về "s" nếu size là true, ngược lại trả về "l"
//        return size ? "s" : "l";
//    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", image=" + image +
                ", category=" + category +
                ", product='" + product + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
    
    
}
