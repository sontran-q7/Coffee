/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;/**
 *
 * @author Acer
 */
public class Category {

    private String ID;
    private String category;
    private String description;

    public Category(String ID, String category, String description) {
        this.ID = ID;
        this.category = category;
        this.description = description;
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

    @Override
    public String toString() {
        return "Category{" + "ID=" + ID + ", category=" + category + ", description=" + description + '}';
    }
}
