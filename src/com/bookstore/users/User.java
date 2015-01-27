package com.bookstore.users;

public class User {

    private String name;
    private String password;

    public User(){}

    public User(String username, String password) {
        this.name = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassword(String pass){
        return this.password.equals(pass);
    }

}
