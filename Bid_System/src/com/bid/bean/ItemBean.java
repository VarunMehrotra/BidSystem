package com.bid.bean;

import com.bid.controller.Date;
import com.bid.controller.InputStream;
import com.bid.controller.Part;
import com.bid.controller.Time;

public class ItemBean {

	private String itemName;
	private String description;
	private String price;
	private String date; 
	private String time;
	private Part filePart;
	private String username;
	//Part filePart = request.getPart("file-upload"); 
    //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
    //InputStream fileContent 

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getItemName() {
		return itemName;
	}
	public ItemBean() {
		itemName="";
		description="";
		price= "0";
		date="";
		time="";
		part=null;
	
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Part getFilePart() {
		return filePart;
	}
	public void setFilePart(Part filePart) {
		this.filePart = filePart;
	}
	
	
	
	
}
