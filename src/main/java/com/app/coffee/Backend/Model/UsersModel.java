/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.Backend.Model;

/**
 *
 * @author Admin
 */

public class UsersModel {
	private int id;
        private String userName;
        private String gender;
        private int phone;   
        private String image;
        private String email;
        private String password;
        private String option;
        private boolean status;
        
        public UsersModel(int id, String userName, String gender, int phone, String image, String email, String password, String option, boolean status) {
        this.id = id;
        this.userName = userName;
        this.gender = gender;
        this.phone = phone;
        this.image = image;
        this.email = email;
        this.password = password;
        this.option = option;
        this.status = status;
    }
       
        public int getId(){
        return id;
        }
        public String getEmail(){
            return email;
        }
        public String getPassword(){
            return password;
        }
        
        public int getPhone(){
            return phone;
        }
        public String getUserName(){
            return userName;
        }
        public String getImage(){
            return image;
        }
        
        public String getOption(){
            return option;
        }
        public String getGender(){
            return gender;
        }
        public boolean getStatus(){
            return status;
        }
        
        public void setId(int id){
            this.id = id;
        }
        public void setUserName(String userName){
            this.userName = userName;
        }
        public void setGender(String gender){
            this.gender = gender;
        }
        public void setPhone(int phone){
            this.phone = phone;
        }
        public void setImage(String image){
            this.image = image;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public void setPassWord(String password){
            this.password = password;
        }
        public void setOption(String option){
            this.option = option;
        }
        
         public void setStatus(boolean status){
            this.status = status;
        }
        
        public UsersModel() {
    // Implement logic here if needed
}
    public String toString() {
        return "userName=" + userName + ", gender=" + gender + ", phone=" + phone + ", image=" + image + ", option=" + option ;
    }
        
}
