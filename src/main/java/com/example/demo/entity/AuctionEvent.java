package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class AuctionEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int event_id;
	
	private String eventName;
	private String email;
    private String contact;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
    
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime startTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime endTime;
	
	@OneToMany(targetEntity = Inventory.class , cascade = CascadeType.ALL)
	@JoinColumn(name="event_id_fk",referencedColumnName = "event_id")
	private List<Inventory> auction_items;
	
	
	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
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
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public List<Inventory> getAuction_items() {
		return auction_items;
	}
	public void setAuction_items(List<Inventory> auction_items) {
		this.auction_items = auction_items;
	}
	
	
	

}
