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
	 
	
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.POST )
	public String bidderSignUpAfter(@ModelAttribute Bidder b , Model m) {
		
		if(bidderRepo.existsByEmail(b.getEmail())) {
			m.addAttribute("message", "email already exists , try another one");
			return "bidderSignUp";
		}
		System.out.println("Bidder added");
		bidderRepo.save(b);
	
		m.addAttribute("message", "Signed Up Successfully");
		return "bidderSignIn";
	}
	
	@RequestMapping(value = "/bidder/signIn" , method = RequestMethod.GET )
	public String bidderSignIn() {
		return "bidderSignIn";
	}
	
	/*@ResponseBody
	@RequestMapping(value = "/bidder/signIn" , method = RequestMethod.POST)
	public String bidderSignInPost(@ModelAttribute("bidder1") Bidder b) {
		
		
		  Bidder bidder = bidderRepo.findByEmail(b.getEmail());
		  
		  if(b.getPassword().equals(bidder.getPassword()))
		  { return "Sign in successful"; }
		 
		
		return "bidderSignIn";
	}*/
	
	
	@RequestMapping(value = "/bidder/signIn" , method = RequestMethod.POST)
	public String bidderSignInPost(@RequestParam("email") String email , @RequestParam("password")String password ,  Model m) {
		
		  
		  if(!bidderRepo.existsByEmail(email)) {
				m.addAttribute("message", "email doesn't exists , Sign up here");
				return "bidderSignUp";
			}
		  
		  Bidder bidder = bidderRepo.findByEmail(email);
		  
		  if(password.equals(bidder.getPassword()))
		  { 
			  System.out.println(password +" type: " +password.getClass().getSimpleName());
			  System.out.println(bidder.getPassword() +" type: "+ bidder.getPassword().getClass().getSimpleName());
			  return "redirect:/bidder/dashboard"; 
		 }
		 
		 m.addAttribute("message", "Wrong Credentials! , try again");
		 return "bidderSignIn";
		  
	}
	
	
	
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
		return "bidderEventView";
	}
	
	
	
}
