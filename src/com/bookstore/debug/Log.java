package com.bookstore.debug;

import java.util.Date;

public class Log {

	public static boolean debugEnabled = false; // Unless specified we don't want debugging mode

	private static Date currentDate = new Date(System.currentTimeMillis());

	public static void log(Object o){
		currentDate.setTime(System.currentTimeMillis());
		System.out.println("[ " + currentDate.toString() + " ][ LOG ] : " + o);
	}

	public static void logDebug(Object o){
		currentDate.setTime(System.currentTimeMillis());
		if(debugEnabled)
			System.out.println("[ " + currentDate.toString() + " ][DEBUG] : " + o);
	}

}
