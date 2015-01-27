package com.bookstore.data;

import com.bookstore.users.User;

import java.util.ArrayList;

public class UserList {

	private static ArrayList<User> users = new ArrayList<User>();

    public static User getUser(String name){
        for(User u : users){
            if(u.getName().equalsIgnoreCase(name)){
                return u;
            }
        }
        return null;
    }

    public static void addUser(User u){
        users.add(u);
    }

}
