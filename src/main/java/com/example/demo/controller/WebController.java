package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.newBid;
import com.example.demo.entity.oldBid;
import com.example.demo.repository.InventoryRepository;

@Controller
public class WebController {
	
	@Autowired
	private InventoryRepository inventoryRepo;
	
	@MessageMapping("/addBid")
	@SendTo("/bid/newBid")
	public newBid increaseBib(oldBid oldbid1)throws InterruptedException
	{
		
		return new newBid( oldbid1.getOldBidValue());
				
	
	}
	
	@MessageMapping("/bidCompleted")
	@SendTo("/bid/placebid") 
	public Inventory completedBid(Inventory inventory) {
		
		Inventory inv = inventoryRepo.findById(inventory.getInventory_id()).orElse(null);
		inv.setSoldPrice(inventory.getSoldPrice());
		inv.setIsSold(inventory.getIsSold());
		inventoryRepo.save(inv);
		
		return inv;
	}

}
