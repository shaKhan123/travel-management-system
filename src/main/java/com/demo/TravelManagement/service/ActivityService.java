package com.demo.TravelManagement.service;

import java.util.List;

import com.demo.TravelManagement.dto.ActivityDto;

public interface ActivityService {

	void signupForActivity(Long activityId, Long passengerId) throws Exception;

	List<ActivityDto> getAvailableActivites();

}