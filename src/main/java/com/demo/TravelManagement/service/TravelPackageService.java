package com.demo.TravelManagement.service;

import com.demo.TravelManagement.dto.TravelPackageDto;

public interface TravelPackageService {
	
	TravelPackageDto getDestinations(Long id) throws Exception;

	TravelPackageDto getPassengers(Long id) throws Exception;

}