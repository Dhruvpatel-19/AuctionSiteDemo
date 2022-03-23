package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventory_id;
     
     private int lot_id;
     private int start_bid;
     private String descc;
     private String name;
     private String image;
     private boolean isSold = false;
     
     
     
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}         


	public Inventory(int inventory_id, int lot_id, int start_bid, String descc, String name, String image,
			boolean isSold) {
		super();
		this.inventory_id = inventory_id;
		this.lot_id = lot_id;
		this.start_bid = start_bid;
		this.descc = descc;
		this.name = name;
		this.image = image;
		this.isSold = isSold;
	}


	public int getInventory_id() {
		return inventory_id;
	}


	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}


	public int getLot_id() {
		return lot_id;
	}


	public void setLot_id(int lot_id) {
		this.lot_id = lot_id;
	}


	public int getStart_bid() {
		return start_bid;
	}


	public void setStart_bid(int start_bid) {
		this.start_bid = start_bid;
	}


	public String getDescc() {
		return descc;
	}


	public void setDescc(String descc) {
		this.descc = descc;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public boolean isSold() {
		return isSold;
	}


	public void setSold(boolean isSold) {
		this.isSold = isSold;
	} 
	
     
}
