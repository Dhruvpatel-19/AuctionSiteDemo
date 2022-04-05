package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Bidder;
import com.example.demo.entity.Seller;
import com.example.demo.repository.SellerRepository;

@Controller
public class SellerController {
	@Autowired
	private SellerRepository sellerRepo;
	@RequestMapping(value = "/seller/signUp" , method = RequestMethod.GET )
	public String bidderSignUp() {
		return "sellerSignUp";
	}
	
	
	@RequestMapping(value = "/seller/signUp" , method = RequestMethod.POST )
	public String bidderSignUpAfter(@ModelAttribute Seller s , Model m) {
		
		if(sellerRepo.existsByEmail(s.getEmail())){
			m.addAttribute("message", "email already exists , try another one");
			return "sellerSignUp";
		}
		
		sellerRepo.save(s);
		m.addAttribute("message", "Signed Up Successfully");
		return "sellerSignIn";
	}
	
	@RequestMapping(value = "/seller/signIn" , method = RequestMethod.GET )
	public String bidderSignIn() {
		return "sellerSignIn";
	}
	
	@RequestMapping(value = "/seller/signIn" , method = RequestMethod.POST)
	public String bidderSignInPost(@RequestParam("email") String email , @RequestParam("password")String password , Model m) {
		
		if(!sellerRepo.existsByEmail(email)){
			m.addAttribute("message", "email doesn't exists , Sign up here");
			return "sellerSignUp";
		}  
		
		Seller seller = sellerRepo.findByEmail(email);
		   
		  if(password.equals(seller.getPassword()))
		  { 
			 
			  return "bidderDashboard"; 
		 }
		  
		  m.addAttribute("message", "Wrong Credentials! , try again");
		  
		 return "sellerSignIn";
		  
	}
}
