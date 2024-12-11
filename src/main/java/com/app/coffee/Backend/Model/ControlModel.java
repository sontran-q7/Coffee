/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Model;

import java.time.LocalDateTime;

/**
 *
 * @author phamv
 */
public class ControlModel {
    private int controlId;
    private WorkingTimeModel workingTime;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private float checkInPay;
    private float checkOutPay;
    private UsersModel account;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String staffList;

    public ControlModel() {}

    public ControlModel(int controlId, WorkingTimeModel workingTime, LocalDateTime checkIn, LocalDateTime checkOut, float checkInPay, float checkOutPay, UsersModel account,String staffList, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.controlId = controlId;
        this.workingTime = workingTime;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.checkInPay = checkInPay;
        this.checkOutPay = checkOutPay;
        this.account = account;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.staffList = staffList;
    }

    public int getControlId() {
        return controlId;
    }

    public void setControlId(int controlId) {
        this.controlId = controlId;
    }

    public WorkingTimeModel getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(WorkingTimeModel workingTime) {
        this.workingTime = workingTime;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public float getCheckInPay() {
        return checkInPay;
    }

    public void setCheckInPay(float checkInPay) {
        this.checkInPay = checkInPay;
    }

    public float getCheckOutPay() {
        return checkOutPay;
    }

    public void setCheckOutPay(float checkOutPay) {
        this.checkOutPay = checkOutPay;
    }

    public UsersModel getAccount() {
        return account;
    }

    public void setAccount(UsersModel account) {
        this.account = account;
    }
     public String getStaffList() {
        return staffList;
    }

    public void setStaffList(String staffList) {
        this.staffList = staffList;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
