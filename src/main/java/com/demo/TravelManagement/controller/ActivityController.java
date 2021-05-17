package com.demo.TravelManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.TravelManagement.dto.ActivityDto;
import com.demo.TravelManagement.service.ActivityService;
import com.demo.TravelManagement.util.GenericResponseHandler;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	ActivityService activityService;
	
	@GetMapping(value = "/signup/activityId/{activityId}/passengerId/{passengerId}")
	ResponseEntity<?> signUpActivites(@PathVariable Long activityId, @PathVariable Long passengerId) throws Exception{
		activityService.signupForActivity(activityId, passengerId);
		
		return new GenericResponseHandler
				.Builder()
				.setStatus(HttpStatus.OK)
				.setMessage("Signed up successfully")
				.create();
	}
	
	@GetMapping(value = "/available")
	ResponseEntity<?> getAvailableActivites() throws Exception{
		List<ActivityDto> activites = activityService.getAvailableActivites();
		
		return new GenericResponseHandler
				.Builder()
				.setStatus(HttpStatus.OK)
				.setMessage("List of available activites fetched successfully")
				.setData(activites)
				.create();
	}
}
