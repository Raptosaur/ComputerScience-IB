package com.bookstore;

import com.bookstore.debug.Log;
import com.bookstore.gui.LoginGUI;

public class Core {

	public static final String version = "v0.1";

	public static void main(String[] args){

		if( args.length > 0 && args[0].equals("debug")) {
			Log.debugEnabled = true;
			Log.log("Debugging enabled.");
		}

		Log.logDebug("Initialising the login window.");
		LoginGUI.showWindow();

	}

}
