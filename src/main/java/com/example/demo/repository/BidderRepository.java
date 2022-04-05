package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Bidder;

@Repository
public interface BidderRepository extends JpaRepository<Bidder, Integer>{
	public Bidder findByEmail(String email);

	public boolean existsByEmail(String email);
}
