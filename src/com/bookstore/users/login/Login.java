package com.bookstore.users.login;

import com.bookstore.LoggedInUserData;
import com.bookstore.data.UserList;
import com.bookstore.debug.Log;
import com.bookstore.users.User;

public class Login {
	
	public static boolean AttemptLogin(String username, String password) {
		User attemptUser = UserList.getUser(username);
		if (attemptUser == null) {
			Log.logDebug("Login - No user found");
			return false;
		}else if (attemptUser.isPassword(password)){
			LoggedInUserData.loggedInUser = attemptUser;
			LoggedInUserData.isLoggedIn = true;
			Log.logDebug("Login - Assigning loggedInUser as "+attemptUser.getUsername());
			return true;
		}else{
			Log.logDebug("Login - Found user but incorrect password");
			return false;
		}
	}
	
}
