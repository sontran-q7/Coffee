package com.app.coffee.menu;

import javax.swing.table.DefaultTableModel;

public class ProductMenu {

    private int product_id;
    private String product_name;
    private float priceS; // Price for size S
    private float priceL; // Price for size L
    private int category_id;
    private String description;
    private String size;
    private int status;
    private DefaultTableModel tableModel;
       private String image;

    public ProductMenu(int product_id, String product_name, float priceS, float priceL, int category_id, String description, String size,  String image, int status) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.priceS = priceS;
        this.priceL = priceL;
        this.category_id = category_id;
        this.description = description;
        this.size = size;
        this.status = status;
        this.image = image; 
        
    }
    
    public ProductMenu(int product_id, String product_name, float priceS, float priceL, int category_id, String description, String size, int status, DefaultTableModel tableModel , String image) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.priceS = priceS;
        this.priceL = priceL;
        this.category_id = category_id;
        this.description = description;
        this.size = size;
        this.status = status;
        this.tableModel = tableModel;
        this.image = image;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setPriceS(float priceS) {
        this.priceS = priceS;
    }

    public void setPriceL(float priceL) {
        this.priceL = priceL;
    }

    public ProductMenu(String product_name) {
        this.product_name = product_name;
    }

    public ProductMenu() {
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getProductId() {
        return product_id;
    }

    public String getProductName() {
        return product_name;
    }

    public float getPriceS() {
        return priceS;
    }

    public float getPriceL() {
        return priceL;
    }

    public int getCategoryId() {
        return category_id;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ProductMenu{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", priceS=" + priceS +
                ", priceL=" + priceL +
                ", category_id=" + category_id +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", status=" + status +
                '}';
    }
}
