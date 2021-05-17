package com.demo.TravelManagement.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class DestinationDto {

private Long id;
	
	private String name;
	private List<ActivityDto> activities;
	
}
