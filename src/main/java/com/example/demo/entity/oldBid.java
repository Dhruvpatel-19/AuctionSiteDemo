package com.example.demo.entity;

public class oldBid {
	
	private int bidderId;
	private String bidderName;
	private int oldBidValue;

	public oldBid() {
	
	}
	
	

	public oldBid(int bidderId, String bidderName, int oldBidValue) {
		super();
		this.bidderId = bidderId;
		this.bidderName = bidderName;
		this.oldBidValue = oldBidValue;
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



	public int getOldBidValue() {
		return oldBidValue;
	}

	public void setOldBidValue(int oldBidValue) {
		this.oldBidValue = oldBidValue;
	}


	

	
}
