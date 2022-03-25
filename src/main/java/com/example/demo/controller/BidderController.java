package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bidder;
import com.example.demo.entity.Inventory;
import com.example.demo.repository.BidderRepository;
import com.example.demo.repository.InventoryRepository;

@RestController
public class BidderController {
	@Autowired
	private BidderRepository repo;
	
	@Autowired
	private InventoryRepository repoInventory ; 
	
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.GET )
	public String bidderSignUp() {
		return "bidderSignUp";
	}
	                        
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.POST )
	public Bidder bidderSignUpAfter(@RequestBody Bidder b) {
		System.out.println("Bidder added");
		//System.out.println(b.getAuction_items());
		return repo.save(b);
		//return "bidderSignUp";
	}
	
	/*
	@RequestMapping(value = "/inventory/add" , method = RequestMethod.POST )
	public void addInventory(@RequestBody Inventory i ) {
		System.out.println("Inventory added");
		repoInventory.save(i);
		//return "bidderSignUp";
	}*/
}
