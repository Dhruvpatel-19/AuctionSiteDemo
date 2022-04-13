package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.AuctionEvent;
import com.example.demo.entity.Auctioneer;
import com.example.demo.repository.AuctionEventRepository;
import com.example.demo.repository.AuctioneerRepository;

@Controller
public class AuctioneerController {
	
	@Autowired
	private AuctionEventRepository auctionRepo;
	
	@Autowired
	private AuctioneerRepository auctioneerRepo;
	
	@RequestMapping(value = "/auctioneer/signUp" , method = RequestMethod.GET )
	public String bidderSignUp() {
		return "auctioneerSignUp";
	}
	
	
	@RequestMapping(value = "/auctioneer/signUp" , method = RequestMethod.POST )
	public String bidderSignUpAfter(@ModelAttribute Auctioneer a , Model m) {
		
		if(auctioneerRepo.existsByEmail(a.getEmail())){
			m.addAttribute("message", "email already exists , try another one");
			return "auctioneerSignUp";
		}
		
		auctioneerRepo.save(a);
		m.addAttribute("message", "Signed Up Successfully");
		return "auctioneerSignIn";
	}
	
	@RequestMapping(value = "/auctioneer/signIn" , method = RequestMethod.GET )
	public String bidderSignIn() {
		return "auctioneerSignIn";
	}
	
	@RequestMapping(value = "/auctioneer/signIn" , method = RequestMethod.POST)
	public String bidderSignInPost(@RequestParam("email") String email , @RequestParam("password")String password , Model m) {
		
		if(!auctioneerRepo.existsByEmail(email)){
			m.addAttribute("message", "email doesn't exists , Sign up here");
			return "auctioneerSignUp";
		}  
		
		Auctioneer auctioneer = auctioneerRepo.findByEmail(email);
		   
		  if(password.equals(auctioneer.getPassword()))
		  { 
			 
			  return "bidderDashboard"; 
		 }
		  
		  m.addAttribute("message", "Wrong Credentials! , try again");
		  
		 return "auctioneerSignIn";
		  
	}
	
	@ResponseBody
	@RequestMapping(value = "/app/bidCompleted" )
	public String bidCompleted(@RequestParam("inventory_id") int inventory_id , @RequestParam("userID")int uid , @RequestParam("soldPrice")int price) {
		System.out.println("inventory_id:"+inventory_id+" userID"+uid+" soldPrice"+price);
		return "done";
	}
	
	@RequestMapping( value = "/auctioneer/event/{event_id}" , method = RequestMethod.GET)
	public String eventView(@PathVariable("event_id")int event_id , Model model) {
		
		AuctionEvent event = auctionRepo.findById(event_id).orElse(null);
		model.addAttribute("auctionName", event.getEventName());
		model.addAttribute("description" , event.getDescAuction());
		model.addAttribute("items", event.getAuction_items());
		return "auctioneerEventView";
	}

}
