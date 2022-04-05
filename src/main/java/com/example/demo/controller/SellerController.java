package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@RequestMapping(value = "/seller/signUp" , method = RequestMethod.POST )
	public String bidderSignUpAfter(@ModelAttribute Seller s) {
		sellerRepo.save(s);
		return "Seller Added Successfully";
	}
	
	@RequestMapping(value = "/seller/signIn" , method = RequestMethod.GET )
	public String bidderSignIn() {
		return "sellerSignIn";
	}
}
