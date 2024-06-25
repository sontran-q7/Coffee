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
   // private int quantity;
    private float total;
    private String description;
    private int table_number;
    private Date day;
    private boolean status;

  
    public int getOrder_detail_id() { return order_detail_id; }
    public void setOrder_detail_id(int order_detail_id) { this.order_detail_id = order_detail_id; }
   // public int getQuantity() { return quantity; }
    //public void setQuantity(int quantity) { this.quantity = quantity; }
    public float getTotal() { return total; }
    public void setTotal(float total) { this.total = total; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getTable_number() { return table_number; }
    public void setTable_number(int table_number) { this.table_number = table_number; }
    public Date getDay() { return day; }
    public void setDay(Date day) { this.day = day; }
    public boolean getStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
   

}

