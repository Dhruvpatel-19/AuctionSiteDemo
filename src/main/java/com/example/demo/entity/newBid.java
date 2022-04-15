package com.example.demo.entity;

public class newBid {
	
	private int bidderId;
	private String bidderName;
	private int newBidValue;
	

	public newBid() {
	
	}
	


	public newBid(int bidderId, String bidderName, int newBidValue) {
		super();
		this.bidderId = bidderId;
		this.bidderName = bidderName;
		this.newBidValue = newBidValue;
	}


	
	public int getBidderId() {
		return bidderId;
	}



	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	
	

	public String getBidderName() {
		return bidderName;
	}



	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}



	public int getNewBidValue() {
		return newBidValue;
	}

	public void setNewBidValue(int newBidValue) {
		this.newBidValue = newBidValue;
	}



	

	
	
	
}
