package com.example.demo.entity;

public class newBid {
	
	private int bidderId;
	private int newBidValue;
	

	public newBid() {
	
	}
	


	public newBid(int bidderId, int newBidValue) {
		super();
		this.bidderId = bidderId;
		this.newBidValue = newBidValue;
	}



	public int getNewBidValue() {
		return newBidValue;
	}

	public void setNewBidValue(int newBidValue) {
		this.newBidValue = newBidValue;
	}



	public int getBidderId() {
		return bidderId;
	}



	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	
	
	
}
