package com.demo.TravelManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.TravelManagement.dto.TravelPackageDto;
import com.demo.TravelManagement.service.TravelPackageService;
import com.demo.TravelManagement.util.GenericResponseHandler;

@RestController
@RequestMapping("/travelPackage")
public class TravelPackageController {
 
	@Autowired
	TravelPackageService travelPackageService;
	
	@GetMapping(value = "{Id}/destinations")
	ResponseEntity<?> getDestinations(@PathVariable Long Id) throws Exception{
		TravelPackageDto  response = travelPackageService.getDestinations(Id);		
		return new GenericResponseHandler
				.Builder()
				.setStatus(HttpStatus.OK)
				.setMessage("Destinations fetched successfully")
				.setData(response)
				.create();
	}
	
	@GetMapping(value = "{Id}/passengers")
	ResponseEntity<?> getPassengers(@PathVariable Long Id) throws Exception{
		TravelPackageDto  response = travelPackageService.getPassengers(Id);		
		return new GenericResponseHandler
				.Builder()
				.setStatus(HttpStatus.OK)
				.setMessage("Passengers fetched successfully")
				.setData(response)
				.create();
	}
}
