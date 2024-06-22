/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.category;/**
 *
 * @author Acer
 */
public class Category {

    private String ID;
    private String category;
    private String description;
    private String status;

    public Category(String ID, String category, String description, String status) {
        this.ID = ID;
        this.category = category;
        this.description = description;
        this.status = status;
    }

    public String getID() {
        
        return ID;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Category{" + "ID=" + ID + ", category=" + category + ", description=" + description + ", status=" + status + '}';
    }
    

}
