package com.example.demo.entity;

public class SoldItem {
	private int inventory_id;
	private int bidderId;
	private int soldPrice;
	public SoldItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SoldItem(int inventory_id, int bidderId, int soldPrice) {
		super();
		this.inventory_id = inventory_id;
		this.bidderId = bidderId;
		this.soldPrice = soldPrice;
	}
	public int getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public int getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}
	
	
	
}
