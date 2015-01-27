package com.bookstore.data;

import com.bookstore.debug.Log;
import com.bookstore.users.User;

import java.util.ArrayList;

public class UserList {

	private static ArrayList<User> users = new ArrayList<User>();

    public static User getUser(String name){
        Log.logDebug("Searching through UserList for accounts with the name " + name);
        for(User u : users){
            Log.logDebug("User " + u.getUsername() + " found");
            if(u.getUsername().equalsIgnoreCase(name)){
                Log.logDebug("Returned " + u.getUsername() + " for search");
                return u;
            }
        }
        Log.logDebug("Could not find a user that matched the name " + name);
        return null;
    }

    public static void addUser(User u){
        users.add(u);
        Log.logDebug("Added user "+u.getUsername() + " " + (u.isAdmin() ? "with" : "without") + " admin privileges");
    }

    public static Object[][] usersTo2DArray(){
        Object[][] data = new Object[users.size()][3];

        for(int i = 0; i < data.length; i++){
            data[i][0] = users.get(i).getUsername();
            data[i][1] = users.get(i).getName();
            data[i][2] = new Boolean(users.get(i).isAdmin());
        }

        return data;
    }

}
