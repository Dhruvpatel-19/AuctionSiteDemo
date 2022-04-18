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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.AuctionEvent;
import com.example.demo.entity.Auctioneer;
import com.example.demo.entity.SoldItem;
import com.example.demo.repository.AuctionEventRepository;
import com.example.demo.repository.AuctioneerRepository;
import com.example.demo.repository.SoldItemRepository;

@Controller
public class AuctioneerController {
	
	@Autowired
	private AuctionEventRepository auctionRepo;
	
	@Autowired
	private AuctioneerRepository auctioneerRepo;
	
	@Autowired
	private SoldItemRepository soldItemRepo;
	
	@RequestMapping(value = "/auctioneer/signUp" , method = RequestMethod.GET )
	public String auctioneerSignUp() {
		return "auctioneerSignUp";
	}
	
	
	@RequestMapping(value = "/auctioneer/signUp" , method = RequestMethod.POST )
	public String auctioneerSignUpAfter(@ModelAttribute Auctioneer a , Model m) {
		
		if(auctioneerRepo.existsByEmail(a.getEmail())){
			m.addAttribute("message", "email already exists , try another one");
			return "auctioneerSignUp";
		}
		
		auctioneerRepo.save(a);
		m.addAttribute("message", "Signed Up Successfully");
		return "auctioneerSignIn";
	}
	
	@RequestMapping(value = "/auctioneer/signIn" , method = RequestMethod.GET )
	public String auctioneerSignIn() {
		return "auctioneerSignIn";
	}
	
	@RequestMapping(value = "/auctioneer/signIn" , method = RequestMethod.POST)
	public String auctioneerSignInPost(HttpServletResponse response ,@RequestParam("email") String email , @RequestParam("password")String password , Model m) {
		
		if(!auctioneerRepo.existsByEmail(email)){
			m.addAttribute("message", "email doesn't exists , Sign up here");
			return "auctioneerSignUp";
		}  
		
		Auctioneer auctioneer = auctioneerRepo.findByEmail(email);
		   
		  if(password.equals(auctioneer.getPassword()))
		  { 
			  
			  Cookie c=new Cookie("auctioneer", email);
			  c.setPath("/");
			  response.addCookie(c);
			 
			  return "redirect:/auctioneer/dashboard"; 
		 }
		  
		  m.addAttribute("message", "Wrong Credentials! , try again");
		  
		 return "auctioneerSignIn";
		  
	}
	
	@ResponseBody
	@RequestMapping(value = "/app/bidCompleted" )
	public String bidCompleted(@RequestParam("inventoryId") int inventoryId , @RequestParam("userID")int uid , @RequestParam("soldPrice")int price) {
		System.out.println("inventoryId:"+inventoryId+" userID"+uid+" soldPrice"+price);
		return "done";
	}
	
	@RequestMapping( value = "/auctioneer/dashboard" , method = RequestMethod.GET)
	public String bidderDashboard(Model model) {
		List<AuctionEvent> auctionList = auctionRepo.findAll(); 
		model.addAttribute("auctionList", auctionList);
		return "auctioneerDashboard";
	}
	
	
	@RequestMapping( value = "/auctioneer/event/{event_id}" , method = RequestMethod.GET)
	public String eventView(HttpServletRequest request ,@PathVariable("event_id")int event_id , Model model) {
		
		
		String cookieinemail = null;
        Cookie[]  c1=request.getCookies();
        for (Cookie c: c1)
        {   
        	
        	System.out.println("Name :"+c.getName()+" Email :"+c.getValue());
        	
            if(c.getName().equals("auctioneer"))
            {
                cookieinemail=c.getValue();
                System.out.println("Auctioneer : "+cookieinemail);
            }
        }
     
		
		AuctionEvent event = auctionRepo.findById(event_id).orElse(null);
		model.addAttribute("auctionName", event.getEventName());
		model.addAttribute("description" , event.getDescAuction());
		model.addAttribute("items", event.getAuction_items());
		
		 List<SoldItem> soldItems = soldItemRepo.findAll();
	     model.addAttribute( "soldItem",soldItems);
	     model.addAttribute("soldItemsSize" , soldItems.size());
		
	     return "auctioneerEventView";
	}

}
