package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bidder;
import com.example.demo.entity.Inventory;
import com.example.demo.repository.BidderRepository;
import com.example.demo.repository.InventoryRepository;

@Controller
public class BidderController {
	@Autowired
	private BidderRepository repo;
	
	@Autowired
	private InventoryRepository repoInventory ; 
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET )
	public String Home() {
		return "Home";
	}
	
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.GET )
	public String bidderSignUp() {
		return "bidderSignUp";
	}
	 
	
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.POST )
	public String bidderSignUpAfter(@ModelAttribute Bidder b) {
		System.out.println("Bidder added");
		repo.save(b);
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/inventory/add" , method = RequestMethod.POST )
	public void addInventory(@RequestBody Inventory i ) {
		System.out.println("Inventory added");
		repoInventory.save(i);
		//return "bidderSignUp";
	}
	
	
}
