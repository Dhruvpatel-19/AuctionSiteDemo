package com.example.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Auctioneer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private int event_id;
	private String name;
	private String password;
	private String email;
    private String contact;
    
	@OneToMany(targetEntity = AuctionEvent.class , cascade = CascadeType.ALL)
	@JoinColumn(name="auctioneer_id_fk",referencedColumnName = "id")
	private List<AuctionEvent> auction_event;

	public Auctioneer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Auctioneer(int id, String name, String password, String email, String contact,
			List<AuctionEvent> auction_event) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.auction_event = auction_event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<AuctionEvent> getAuction_event() {
		return auction_event;
	}

	public void setAuction_event(List<AuctionEvent> auction_event) {
		this.auction_event = auction_event;
	}
     
    

}

