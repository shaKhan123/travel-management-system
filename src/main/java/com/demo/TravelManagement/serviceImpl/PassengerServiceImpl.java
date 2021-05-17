package com.demo.TravelManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.TravelManagement.dto.PassengerDto;
import com.demo.TravelManagement.entity.Passenger;
import com.demo.TravelManagement.error.NotFoundException;
import com.demo.TravelManagement.mapper.PassengerMapper;
import com.demo.TravelManagement.repository.PassengerActivityRepository;
import com.demo.TravelManagement.repository.PassengerRepository;
import com.demo.TravelManagement.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	PassengerActivityRepository passengerActivityRepository;

	@Override
	public PassengerDto printPassengers(Long Id) throws Exception {
		Passenger passenger = passengerRepository.findById(Id)
				.orElseThrow(() -> new NotFoundException("Passenger not found"));
		return PassengerMapper.toPassengerDto(passenger);
	}
}
