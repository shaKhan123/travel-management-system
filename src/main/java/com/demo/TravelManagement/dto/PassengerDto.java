package com.demo.TravelManagement.dto;

import java.util.Set;

import com.demo.TravelManagement.entity.Membership;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PassengerDto {

	private Long id;
	private String name;	
	private Integer passengerNumber;
	private Integer balance;
	private Membership membership;
	private Set<ActivityDto> activities;
	
}
