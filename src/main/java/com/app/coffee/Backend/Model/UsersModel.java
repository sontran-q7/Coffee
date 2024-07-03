/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Model;

import java.util.List;

/**
 *
 * @author Admin
 */

public class UsersModel {
	private int account_id;
        private String username;
        private String image;
        private String password;
        private String phone;  
        private Role role;
        private int status;
        private String email;
        

        
        public UsersModel(int account_id, String username, String image, String password, String phone,Role role, int status, String email) {
        this.account_id = account_id;
        this.username = username;
        this.image = image;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.status = status;
        this.email = email;
        
    }

    public UsersModel(int aInt, String string, String string0, int aInt0, String string1, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public UsersModel() {
        this.account_id = 0;
        this.username = "";
        this.password = "";
        this.phone = "";
        this.role = null;
        this.status = 0;
        this.email = "";
    }
       
    

        public String getImage() {
            return image;
        }
        public int getAccount_id(){
        return account_id;
        }
        public String getEmail(){
            return email;
        }
        public String getPassword(){
            return password;
        }
        
        public String getPhone(){
            return phone;
        }
        public String getUserName(){
            return username;
        }     
        public int getStatus(){
            return status;
        }
        
        public void setAccount_id(int account_id){
            this.account_id = account_id;
        }
        public void setUserName(String username){
            this.username = username;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        public Role getRole() {
            return role;
        }

        public void setPhone(String phone){
            this.phone = phone;
        }

        public void setEmail(String email){
            this.email = email;
        }

        public void setImage(String image) {
            this.image = image;
        }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
        public void setPassWord(String password){
            this.password = password;
        }

       
      
}
