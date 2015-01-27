package com.bookstore.debug;

public class Log {

	public static boolean debugEnabled = false; // Unless specified we don't want debugging mode

	public static void log(Object o){
		System.out.println(o);
	}

	public static void logDebug(Object o){
		if(debugEnabled)
			System.out.println(o);
	}

}
