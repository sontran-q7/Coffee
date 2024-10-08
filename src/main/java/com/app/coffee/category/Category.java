/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.category;/**
 *
 * @author Acer
 */
public class Category {

    private int category_id;;
    private String category_name;
    private String description;
    private String status;
    
    public Category() {
    }

    public Category(int category_id, String category_name, String description, String status) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.description = description;
        this.status = status;
    }
    // set
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // get
    public int getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    
    @Override
    public String toString() {
    return this.category_name; // This will be displayed in the JComboBox
//        return "Category{" + "category_id=" + category_id + ", category_name=" + category_name + ", description=" + description + ", status=" + status + '}';
    }
}
