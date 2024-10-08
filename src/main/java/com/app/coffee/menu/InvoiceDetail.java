package com.app.coffee.menu;

public class InvoiceDetail {
    private int productId;
    private String size;
    private float price;
    private int quantity;
    private String sugar;
    private float tableNumber;
    private String note;
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public float getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(float tableNumber) {
        this.tableNumber = tableNumber;
    }
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
