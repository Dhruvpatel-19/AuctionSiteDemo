package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.SoldItem;

@Repository
public interface SoldItemRepository extends JpaRepository<SoldItem , Integer>{

}
