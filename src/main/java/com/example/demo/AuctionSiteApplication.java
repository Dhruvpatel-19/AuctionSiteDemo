package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.CatalogController;

@SpringBootApplication
public class AuctionSiteApplication {

	public static void main(String[] args) {
		System.out.println("Dir = "+ CatalogController.uploadingdDir);
		new File(CatalogController.uploadingdDir).mkdir();
		SpringApplication.run(AuctionSiteApplication.class, args);
		System.out.println("App Started..");
	}

}
