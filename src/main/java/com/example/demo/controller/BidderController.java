package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Bidder;

public class BidderController {
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.GET )
	public String bidderSignUp() {
		return "bidderSignUp";
	}
	
	@RequestMapping(value = "/bidder/signUp" , method = RequestMethod.POST )
	public String bidderSignUpAfter(Bidder b) {
		return "bidderSignUp";
	}
}
