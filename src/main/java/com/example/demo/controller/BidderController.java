package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.AuctionEvent;
import com.example.demo.entity.Bidder;
import com.example.demo.entity.Inventory;
import com.example.demo.repository.AuctionEventRepository;
import com.example.demo.repository.BidderRepository;
import com.example.demo.repository.InventoryRepository;

@Controller
public class BidderController {
	@Autowired
	private BidderRepository bidderRepo;
	
	@Autowired
	private AuctionEventRepository auctionRepo;
	
	
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET )
	public String Home() {
		return "Home";
	}
	
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.GET )
	public String bidderSignUp() {
		return "bidderSignUp";
	}
	 
	@ResponseBody
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.POST )
	public String bidderSignUpAfter(@ModelAttribute Bidder b) {
		System.out.println("Bidder added");
		bidderRepo.save(b);
		//return "redirect:/home";
		return "Bidder Added Successfully";
	}
	
	@RequestMapping(value = "/bidder/signIn" , method = RequestMethod.GET )
	public String bidderSignIn() {
		return "bidderSignIn";
	}
	
	/*@RequestMapping(value = "/inventory/add" , method = RequestMethod.POST )
	public void addInventory(@RequestBody Inventory i ) {
		System.out.println("Inventory added");
		repoInventory.save(i);
		//return "bidderSignUp";
	}*/
	
	
	@RequestMapping( value = "/bidder/dashboard" , method = RequestMethod.GET)
	public String bidderDashboard(Model model) {
		List<AuctionEvent> auctionList = auctionRepo.findAll(); 
		model.addAttribute("auctionList", auctionList);
		return "bidderDashboard";
	}
	
	@RequestMapping( value = "/bidder/event/{event_id}" , method = RequestMethod.GET)
	public String eventView(@PathVariable("event_id")int event_id , Model model) {
		
		AuctionEvent event = auctionRepo.findById(event_id).orElse(null);
		model.addAttribute("auctionName", event.getEventName());
		model.addAttribute("description" , event.getDescAuction());
		model.addAttribute("items", event.getAuction_items());
		return "eventView";
	}
	
	
	
}
