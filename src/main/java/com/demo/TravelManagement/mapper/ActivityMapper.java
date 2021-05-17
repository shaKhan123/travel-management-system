package com.demo.TravelManagement.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.demo.TravelManagement.dto.ActivityDto;
import com.demo.TravelManagement.dto.DestinationDto;
import com.demo.TravelManagement.entity.Activity;
import com.demo.TravelManagement.entity.PassengerActivity;

public class ActivityMapper {

	public static List<ActivityDto> toActivityDtoList(List<Activity> activities){
		return activities
			.stream()
			.map(activity -> toActivityDto(activity))
			.collect(Collectors.toList());
	}
	
	public static ActivityDto toActivityDto(Activity activity) {
		ActivityDto activityDto = new ActivityDto();
		activityDto.setCapacity(activity.getCapacity());
		activityDto.setCost(activity.getCost());
		activityDto.setDescription(activity.getDescription());
		activityDto.setId(activity.getId());
		activityDto.setName(activity.getName());
		activityDto.setSignedUp(activity.getSignedUp());
		return activityDto;
	}
	
	public static List<ActivityDto> toActivityDtoListForAvailableActivites(List<Activity> activities) {
		return toActivityDtoList(activities)
		.stream()
		.map(activityDto -> {
			activityDto.setSpaceAvailable(activityDto.getCapacity() - activityDto.getSignedUp());
			activityDto.setCapacity(null);
			activityDto.setSignedUp(null);
			return activityDto;
		})
		.collect(Collectors.toList());

	}

	public static Set<ActivityDto> toActivityDtoListFromPassengerActivity(Set<PassengerActivity> passengerActivities){
		return passengerActivities
			.stream()
			.map(passengerActivity -> toActivityDtoFromPassengerActivity(passengerActivity))
			.collect(Collectors.toSet());
	}
	
	public static ActivityDto toActivityDtoFromPassengerActivity(PassengerActivity passengerActivity) {
		ActivityDto dto = new ActivityDto();
		dto.setCapacity(passengerActivity.getActivity().getCapacity());
		dto.setCost(passengerActivity.getActivity().getCost());
		dto.setDescription(passengerActivity.getActivity().getDescription());
		dto.setName(passengerActivity.getActivity().getName());
		dto.setPricePad(passengerActivity.getPricePaid());		
		dto.setDestination(toDestinationDto(passengerActivity));
		return dto;
	}
	
	public static DestinationDto toDestinationDto(PassengerActivity passengerActivity) {
		DestinationDto destinationDto = new DestinationDto();
		destinationDto.setName(passengerActivity.getActivity().getDestination().getName());
		destinationDto.setId(passengerActivity.getActivity().getDestination().getId());	
		return destinationDto;
	}
	
}
