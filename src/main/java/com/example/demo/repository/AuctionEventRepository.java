package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AuctionEvent;
import com.example.demo.entity.Inventory;

@Repository
public interface AuctionEventRepository extends JpaRepository<AuctionEvent, Integer>{
	
}
