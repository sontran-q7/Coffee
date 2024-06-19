/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Model;

/**
 *
 * @author Admin
 */
public class Role {
    private int role_id;
    private String name;
    public Role(int role_id, String name){
        this.role_id = role_id;
        this.name = name;
    }

    public int getRole_id() {
        return role_id;
    }

    public String getName() {
        return name;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setName(String name) {
        this.name = name;
    } 
    public String toString() {
        return name; 
    }
}
