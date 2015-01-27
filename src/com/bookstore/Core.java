package com.bookstore;

import com.bookstore.debug.Log;

public class Core {

	public static boolean showingWindow;
	
	public static void main(String[] args){
		while(!LoggedInUserData.isLoggedIn){
			if(!showingWindow){
				showWindow();
			}
		}
	}
	
	public static void showWindow(){
		showingWindow = true;
		Log.log("System login window is now being displayed.");
	}
	
}
