package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bidder;
import com.example.demo.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
}
