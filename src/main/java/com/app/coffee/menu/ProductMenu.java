package com.app.coffee.menu;

public class ProductMenu {

    private int product_id;
    private String product_name;
    private float price;
    private int category_id;
    private String description;
    private String size;
    private int status;

    public ProductMenu(int product_id, String product_name, float price, int category_id, String description, String size, int status ) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.category_id = category_id;
        this.description = description;
        this.size = size;
        this.status = status;
    }

    public ProductMenu(String product_name ) {
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

    public void setPrice(float price) {
        this.price = price;
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

    public float getPrice() {
        return price;
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
                ", price=" + price +
                ", category_id=" + category_id +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", status=" + status  +
                '}';
    }
}
