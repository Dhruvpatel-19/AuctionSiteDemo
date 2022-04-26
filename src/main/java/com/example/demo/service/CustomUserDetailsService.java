package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Auctioneer;
import com.example.demo.entity.Bidder;
import com.example.demo.repository.AuctioneerRepository;
import com.example.demo.repository.BidderRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private BidderRepository bidderRepo;
	
	@Autowired
	private AuctioneerRepository auctioneerRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		boolean bidderExist = bidderRepo.existsByEmail(email);
		
		boolean autioneerExist = auctioneerRepo.existsByEmail(email);
		
		if(bidderExist) {
			Bidder b = bidderRepo.findByEmail(email);
			return new User(b.getEmail() , b.getPassword() , new ArrayList<>());
		}
		 
		if(autioneerExist) {
			Auctioneer a = auctioneerRepo.findByEmail(email);
			new User( a.getEmail() , a.getPassword() , new ArrayList<>());
		 }
		
		throw new UsernameNotFoundException("User doesn't exist");
	}

}
