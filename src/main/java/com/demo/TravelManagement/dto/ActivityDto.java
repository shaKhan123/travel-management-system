package com.demo.TravelManagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ActivityDto {

	private Long id;

	private String name;

	private String description;

	private Integer cost;

	private Integer capacity;

	private Integer signedUp;

	private DestinationDto destination;
	
	private Integer pricePad;
	
	private Integer spaceAvailable;
	
	
}
