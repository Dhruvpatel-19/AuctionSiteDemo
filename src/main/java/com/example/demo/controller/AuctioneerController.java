package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.AuctionEvent;
import com.example.demo.repository.AuctionEventRepository;

@Controller
public class AuctioneerController {
	
	@Autowired
	private AuctionEventRepository auctionRepo;
	
	@RequestMapping( value = "/auctioneer/event/{event_id}" , method = RequestMethod.GET)
	public String eventView(@PathVariable("event_id")int event_id , Model model) {
		
		AuctionEvent event = auctionRepo.findById(event_id).orElse(null);
		model.addAttribute("auctionName", event.getEventName());
		model.addAttribute("description" , event.getDescAuction());
		model.addAttribute("items", event.getAuction_items());
		return "auctioneerEventView";
	}

}
