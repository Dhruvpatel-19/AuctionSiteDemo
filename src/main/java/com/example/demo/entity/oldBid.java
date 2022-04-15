package com.example.demo.entity;

public class oldBid {
	
	private int bidderId;
	private int oldBidValue;

	public oldBid() {
	
	}
	

	public oldBid(int bidderId, int oldBidValue) {
		super();
		this.bidderId = bidderId;
		this.oldBidValue = oldBidValue;
	}


	public int getOldBidValue() {
		return oldBidValue;
	}

	public void setOldBidValue(int oldBidValue) {
		this.oldBidValue = oldBidValue;
	}


	public int getBidderId() {
		return bidderId;
	}


	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	
}
