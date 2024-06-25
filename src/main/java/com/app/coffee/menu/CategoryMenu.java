/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.menu;

/**
 *
 * @author admin
 */
public class CategoryMenu {

    private int category_id;
    private String description;
    private int status;
    private String categoryName;

    public CategoryMenu(int category_id, String categoryName, String description, int status) {
        this.category_id = category_id;
        
        this.description = description;
        this.status = status;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return category_id;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public String getCategoryName() {
        return categoryName;
    }
    
    @Override
    public String toString() {
        return "Category{" + ", category_id=" + category_id + ", description=" + description + ", status=" + status + ", category_name=" + categoryName + '}';
    }
    

}
