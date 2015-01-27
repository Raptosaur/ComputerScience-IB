package com.bookstore.data;

import java.util.ArrayList;

import com.bookstore.data.objects.Item;

public class ItemList {
	
	private static ArrayList<Item> list = new ArrayList<Item>();
	
	public static void addItem(Item i){
		list.add(i);
	}
	
	public static ArrayList<Item> findItem(String find){
		ArrayList<Item> found = new ArrayList<Item>();
		for(Item i : list){
			if(i.getBarcode().contains(find) || i.getID().contains(find) || i.getISBN().contains(find))
				found.add(i);
		}
		
		return found;
	}
	
}
