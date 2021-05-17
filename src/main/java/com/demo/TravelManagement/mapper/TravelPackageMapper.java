package com.demo.TravelManagement.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.demo.TravelManagement.dto.DestinationDto;
import com.demo.TravelManagement.dto.PassengerDto;
import com.demo.TravelManagement.dto.TravelPackageDto;
import com.demo.TravelManagement.entity.Destination;
import com.demo.TravelManagement.entity.TravelPackage;

public class TravelPackageMapper {

	   public static TravelPackageDto toTravelPackageDto(TravelPackage travelPackage) {
		    TravelPackageDto dto = new TravelPackageDto();
			dto.setPackageName(travelPackage.getName());
			dto.setDestinations(converToDestinationDtoList(travelPackage.getDestinations()));
			return dto;
	   }
		
	   public static List<DestinationDto> converToDestinationDtoList(List<Destination> destinations){
		   return destinations.stream()
					.map(destination -> {
						DestinationDto dto = new DestinationDto();
						dto.setName(destination.getName());
						dto.setActivities(ActivityMapper.toActivityDtoList(destination.getActivities()));
						return dto;
					}).collect(Collectors.toList());
	   }
	   
	   public static TravelPackageDto toTravelPackageDtoForPassengers(TravelPackage travelPackage) {
		   List<PassengerDto> passengers = PassengerMapper.toPassengerDtoList(travelPackage.getPassengers());
					
					TravelPackageDto dto = new TravelPackageDto();
					dto.setPackageName(travelPackage.getName());
					dto.setPassengerCapacity(travelPackage.getPassengerCapacity());
					dto.setPassengerCount(travelPackage.getPassengers().size());
					dto.setPassengers(passengers);	
					return dto;
	   }
	   

}
