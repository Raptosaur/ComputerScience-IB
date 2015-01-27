package com.bookstore.data.objects;

import com.bookstore.users.User;

public abstract class Item {

	private String mID,
		mBarCode,
		mISBN;
	private User mCurrentHolder = null,
			mIssuer = null;
	
	public void returnItem(){
		this.mCurrentHolder = null; // Set the current holder to be null
		this.setIssuer(null); // Set the issuer to be null
	}
	
	public boolean issueItem(User person){ // Issue this book to a user
		if(this.mCurrentHolder == null){ // If nobody has this book
			this.mCurrentHolder = person; // Set the user that was passed over as the current holder
		}else{
			return false; // If the book is already taken out return false
		}
		return true; // In case of any errors return true
	}
	
	public boolean isIssued(){
		return this.mCurrentHolder != null; // Return whether the current holder is actually set
	}
	
	public User getIssuer(){
		return this.mIssuer; // Return the current issuer of the item
	}
	
	public void setIssuer(User issuer){
		this.mIssuer = issuer; // Set the private variable
	}
	
	public String getBarcode(){
		return this.mBarCode; // Return the barcode that has been assigned to the book
	}

	public void setBarcode(String barcode){
		this.mBarCode = barcode; // Set the barcode
	}
	
	public String getISBN(){
		return this.mISBN;
	}
	
	public void setISBN(String isbn){
		this.mISBN = isbn; // Set the ISBN
	}
	
	public String getID(){
		return this.mID; // Return the ID for the Item
	}
	
	public void setID(String id){
		this.mID = id; // Set the ID
	}
	
}
