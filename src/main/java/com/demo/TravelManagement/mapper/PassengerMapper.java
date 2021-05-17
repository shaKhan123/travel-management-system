package com.demo.TravelManagement.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.demo.TravelManagement.dto.PassengerDto;
import com.demo.TravelManagement.entity.Passenger;

public class PassengerMapper {

	public static PassengerDto toPassengerDto(Passenger passenger) {
		PassengerDto passengerDto = new PassengerDto();
		passengerDto.setId(passenger.getId());
		passengerDto.setName(passenger.getName());
		passengerDto.setPassengerNumber(passenger.getPassengerNumber());
		passengerDto.setBalance(passenger.getBalance());
		passengerDto.setActivities(ActivityMapper.toActivityDtoListFromPassengerActivity(passenger.getPassengerActivity()));
		return passengerDto;
	}
	
	   public static List<PassengerDto> toPassengerDtoList(List<Passenger> passengers){
		   return passengers.stream()
			.map(passenger -> {
				PassengerDto dto = new PassengerDto();
				dto.setName(passenger.getName());
				dto.setPassengerNumber(passenger.getPassengerNumber());
				return dto;
			}).collect(Collectors.toList());
	   }
}
