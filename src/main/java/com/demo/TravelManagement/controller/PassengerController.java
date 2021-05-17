package com.demo.TravelManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.TravelManagement.dto.PassengerDto;
import com.demo.TravelManagement.service.PassengerService;
import com.demo.TravelManagement.util.GenericResponseHandler;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	
	@Autowired
	PassengerService passengerService;
	
	@GetMapping(value = "{Id}")
	ResponseEntity<?> getDestinations(@PathVariable Long Id) throws Exception{
		PassengerDto passengerDto = passengerService.printPassengers(Id);	
		
		 return new GenericResponseHandler
				.Builder()
				.setStatus(HttpStatus.OK)
				.setMessage("Passengers fetched successfully")
				.setData(passengerDto)
				.create();
	}

}
