/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Model;

import java.util.Date;

/**
 *
 * @author anhso
 */
public class PendingBill {
    private int order_detail_id;
    private int quantity;
    private float total;
    private String description;
    private Date day;

    // Getters và Setters cho các thuộc tính
    public int getOrder_detail_id() { return order_detail_id; }
    public void setOrder_detail_id(int order_detail_id) { this.order_detail_id = order_detail_id; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public float getTotal() { return total; }
    public void setTotal(float total) { this.total = total; }
   // public int getNo() { return no; }
   // public void setNo(int no) { this.no = no; }
    //public int getTableNumber() { return tableNumber; }
   // public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Date getDay() { return day; }
    public void setDay(Date day) { this.day = day; }

   

    

    

}

