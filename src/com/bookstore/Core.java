package com.bookstore;

import com.bookstore.data.UserList;
import com.bookstore.debug.Log;
import com.bookstore.gui.LoadingScreenGUI;
import com.bookstore.gui.LoginGUI;
import com.bookstore.users.User;

public class Core {

	public static final String version = "v0.1";

	public static void main(String[] args){

		if( args.length > 0 && args[0].equals("debug")) {
			Log.debugEnabled = true;
			Log.log("Debugging enabled.");
		}

		LoadingScreenGUI.showWindow();

		UserList.addUser(new User("Admin","admin",true));
		UserList.addUser(new User("User","user"));

		LoadingScreenGUI.disposeOfWindow();

		Log.logDebug("Initialising the login window.");
		LoginGUI.showWindow();

	}

}
