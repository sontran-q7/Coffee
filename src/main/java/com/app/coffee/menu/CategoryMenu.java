package com.app.coffee.menu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CategoryMenu {

    private int category_id;
    private String description;
    private int status;
    private String categoryName;
    private PropertyChangeSupport support;

    public CategoryMenu(int category_id, String categoryName, String description, int status) {
        this.category_id = category_id;
        this.description = description;
        this.status = status;
        this.categoryName = categoryName;
        this.support = new PropertyChangeSupport(this);
    }

    public CategoryMenu() {
        this.support = new PropertyChangeSupport(this);
    }

    public void setCategoryId(int category_id) {
        int oldCategoryId = this.category_id;
        this.category_id = category_id;
        support.firePropertyChange("category_id", oldCategoryId, category_id);
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

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public String toString() {
        return "Category{" + ", category_id=" + category_id + ", description=" + description + ", status=" + status + ", category_name=" + categoryName + '}';
    }
}
