package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.AuctionEvent;
import com.example.demo.entity.Inventory;
import com.example.demo.repository.AuctionEventRepository;



@Controller
public class CatalogController {
	
	@Autowired
	private AuctionEventRepository repo;
	
	public static final String uploadingdDir = System.getProperty("user.dir") + "/src/main/webapp/catalogimage" ; 
	
	@RequestMapping(value ="/auctionCatalog" , method = RequestMethod.GET )
	public String auctionCatalog() {
		return "auctionCatalog";
	}
	
	
	@RequestMapping(value = "/auctionhouse/auction" , method = RequestMethod.POST) 
	public String addAuction(@ModelAttribute AuctionEvent auctionEvent,@RequestParam("name") ArrayList<String> itemName ,  @RequestParam("image") ArrayList<MultipartFile> file  , @RequestParam("start_bid") ArrayList<Integer> start_bid , @RequestParam("descc") ArrayList<String>  descc) {
		int n = itemName.size();
		ArrayList<Inventory> list = new ArrayList<Inventory>();
		for(int i=0 ; i<n ;i++) {
			Inventory inventory = new Inventory();
			inventory.setName(itemName.get(i));
			inventory.setStart_bid(start_bid.get(i));
			inventory.setDescc(descc.get(i));
			
			
	        MultipartFile f=file.get(i);      
	        String filename=f.getOriginalFilename();
	        Path fileNameAndPath =Paths.get(uploadingdDir,filename);
	        try {
	            Files.write(fileNameAndPath, f.getBytes());
	         } catch (IOException e) {
	            // TODO Auto-generated catch block
	               e.printStackTrace();
	        }
	        inventory.setImage(filename);
	        list.add(inventory);
	        //inventoryRepo.save(inventory);
		}
		auctionEvent.setAuction_items(list);
		repo.save(auctionEvent);
		return "Home";
	}
}
