/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Model;

/**
 *
 * @author phamv
 */
public class WorkingTimeModel {
    private int workingTimeId;
    private String name;
    private String durant;

    public WorkingTimeModel() {
    }

    public WorkingTimeModel(int workingTimeId, String name, String durant) {
        this.workingTimeId = workingTimeId;
        this.name = name;
        this.durant = durant;
    }

    public int getWorkingTimeId() {
        return workingTimeId;
    }

    public void setWorkingTimeId(int workingTimeId) {
        this.workingTimeId = workingTimeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDurant() {
        return durant;
    }

    public void setDurant(String durant) {
        this.durant = durant;
    }
    
    
}   
