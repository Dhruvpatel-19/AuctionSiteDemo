package com.example.demo.controller;

//https://www.youtube.com/watch?v=MH9tm2WYS68
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Bidder;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.SoldItem;
import com.example.demo.entity.newBid;
import com.example.demo.entity.oldBid;
import com.example.demo.repository.BidderRepository;
import com.example.demo.repository.InventoryRepository;

@Controller
public class WebController {
	
	@Autowired
	private InventoryRepository inventoryRepo;
	
	@Autowired
	private BidderRepository bidderRepo;
	
	@MessageMapping("/addBid")
	@SendTo("/bid/newBid")
	public newBid increaseBib(oldBid oldbid1)throws InterruptedException
	{
		
		return new newBid(oldbid1.getBidderId() , oldbid1.getOldBidValue());
				
	
	}
	
	/*@MessageMapping("/bidCompleted")
	@SendTo("/bid/placebid") 
	public Inventory completedBid(Inventory inventory) {
		
		Inventory inv = inventoryRepo.findById(inventory.getInventory_id()).orElse(null);
		inv.setSoldPrice(inventory.getSoldPrice());
		inv.setIsSold(inventory.getIsSold());
		inventoryRepo.save(inv);
		
		return inv;
	}*/
	
	@MessageMapping("/bidCompleted")
	@SendTo("/bid/placebid") 
	public SoldItem completedBid(SoldItem soldItem) {
		
		/*Inventory inv = inventoryRepo.findById(inventory.getInventory_id()).orElse(null);
		inv.setSoldPrice(inventory.getSoldPrice());
		inv.setIsSold(inventory.getIsSold());
		inventoryRepo.save(inv);
		*/
		Bidder b = bidderRepo.findById(soldItem.getBidderId()).orElse(null);
		
		Inventory inv = inventoryRepo.findById(soldItem.getInventory_id()).orElse(null);
		inv.setSoldPrice(soldItem.getSoldPrice());
		inv.setIsSold(true);
		
		List<Inventory> listInventory = bidderRepo.findAuctionItemsByBidder(soldItem.getBidderId());
	
		listInventory.add(inv);
		
		
		/*
		System.out.println("-------------------------------------------------------------");
		System.out.println("Bidder type : "+b.getClass());
		System.out.println("b.getAuction_items() Type : " +b.getAuction_items().getClass()); //org.hibernate.collection.internal.PersistentBag
		System.out.println("list Type : " +listInventory.getClass());
		System.out.println("All bidder type : " +bidderRepo.findAll().getClass());
		System.out.println("-------------------------------------------------------------");
		*/
	
		b.setAuction_items(listInventory);
		
		bidderRepo.save(b);
		
		
		return soldItem;
	}

}
