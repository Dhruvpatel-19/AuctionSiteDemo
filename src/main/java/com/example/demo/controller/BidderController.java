package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.entity.AuctionEvent;
import com.example.demo.entity.Bidder;

import com.example.demo.repository.AuctionEventRepository;
import com.example.demo.repository.BidderRepository;


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
	public String bidderSignInPost( HttpServletResponse response , @RequestParam("email") String email , @RequestParam("password")String password ,  Model m ) {
		
		  
		  if(!bidderRepo.existsByEmail(email)) {
				m.addAttribute("message", "email doesn't exists , Sign up here");
				return "bidderSignUp";
			}
		  
		  Bidder bidder = bidderRepo.findByEmail(email);
		  
		  if(password.equals(bidder.getPassword()))
		  { 
			  System.out.println(password +" type: " +password.getClass().getSimpleName());
			  System.out.println(bidder.getPassword() +" type: "+ bidder.getPassword().getClass().getSimpleName());
			  
			  Cookie c=new Cookie("bidder", email);
			  c.setPath("/");
			  response.addCookie(c);
			  
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
	public String eventView(HttpServletRequest request , @PathVariable("event_id")int event_id , Model model) {
		
		AuctionEvent event = auctionRepo.findById(event_id).orElse(null);
		model.addAttribute("auctionName", event.getEventName());
		model.addAttribute("description" , event.getDescAuction());
		model.addAttribute("items", event.getAuction_items());
		
		System.out.println("----------------------------");
		String cookieinemail = null;
        Cookie[]  c1=request.getCookies();
        for (Cookie c: c1)
        {
        	System.out.println("Name :"+c.getName()+" Email :"+c.getValue());
        	
            if(c.getName().equals("bidder"))
            {
                cookieinemail=c.getValue();
                System.out.println("Bidder : "+cookieinemail);
            }
        }
        System.out.println("------------------------------");
		
        Bidder b = bidderRepo.findByEmail(cookieinemail);
        int bidderId = b.getId();
        System.out.println("Bidder ID is : "+bidderId);
        model.addAttribute("bidderId", bidderId);
		return "bidderEventView";
	}
	
	
	
}
