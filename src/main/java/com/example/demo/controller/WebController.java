package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.entity.newBid;
import com.example.demo.entity.oldBid;

@Controller
public class WebController {
	
	@MessageMapping("/addBid")
	@SendTo("/bid/newBid")
	public newBid increaseBib(oldBid oldbid1)throws InterruptedException
	
	{
		//return new newBid(  HtmlUtils.htmlEscape( oldbid1.getOldBidValue()) );
		
//		return new newBid(
//				HtmlUtils.htmlEscape( oldbid1.getOldBidValue() + ""));
		
		return new newBid( oldbid1.getOldBidValue() + 10);
				
	
	}
	

}
