package com.app.coffee.Login.LoginAccount;

public class UsersModel {
	private int id;
        private String userName;
        private int gender;
        private int phone;   
        private String image;
         private String email;
        private String password;
        private String option;
        
        public UsersModel(int id, String userName, int gender, int phone, String image, String email, String password, String option) {
        this.id = id;
        this.userName = userName;
        this.gender = gender;
        this.phone = phone;
        this.image = image;
        this.email = email;
        this.password = password;
        this.option = option;
    }
       
        public int getId(){
        return id;
        }
        public String getEmail(){
            return email;
        }
        public String getPassWord(){
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
        public int getGender(){
            return gender;
        }
        
    public String toString() {
        return "userName=" + userName + ", gender=" + gender + ", phone=" + phone + ", image=" + image + ", option=" + option ;
    }
        
}
