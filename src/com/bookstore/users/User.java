package com.bookstore.users;

import com.bookstore.LoggedInUserData;

public class User {

    private String name = "Undefined";
    private String password;
    private String username;
    private boolean isAdmin = false;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isPassword(String pass){
        return this.password.equals(pass);
    }

    public boolean isAdmin(){
        return this.isAdmin;
    }

    public void makeAdmin(){
        if(LoggedInUserData.loggedInUser.isAdmin())
            this.isAdmin = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
