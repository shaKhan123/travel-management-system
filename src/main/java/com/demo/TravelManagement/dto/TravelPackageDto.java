package com.demo.TravelManagement.dto;

import java.util.List;

import com.demo.TravelManagement.entity.Destination;
import com.demo.TravelManagement.entity.Passenger;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class TravelPackageDto {

	private String packageName;
	private String passengerCapacity;
	private List<DestinationDto> destinations;
	private List<PassengerDto> passengers;
	private int passengerCount;

}
