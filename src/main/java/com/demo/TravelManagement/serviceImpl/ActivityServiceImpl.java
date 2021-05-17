package com.demo.TravelManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.TravelManagement.dto.ActivityDto;
import com.demo.TravelManagement.entity.Activity;
import com.demo.TravelManagement.entity.Membership;
import com.demo.TravelManagement.entity.Passenger;
import com.demo.TravelManagement.entity.PassengerActivity;
import com.demo.TravelManagement.entity.PassengerActivityKey;
import com.demo.TravelManagement.error.BadRequestException;
import com.demo.TravelManagement.error.NotFoundException;
import com.demo.TravelManagement.mapper.ActivityMapper;
import com.demo.TravelManagement.repository.ActivityRepository;
import com.demo.TravelManagement.repository.PassengerActivityRepository;
import com.demo.TravelManagement.repository.PassengerRepository;
import com.demo.TravelManagement.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	PassengerActivityRepository passengerActivityRepository;

	@Override
	@Transactional
	public void signupForActivity(Long activityId, Long passengerId) throws Exception {

		int finalPrice = 0;

		Activity activity = activityRepository.findById(activityId)
				.orElseThrow(() -> new NotFoundException("Activity not found."));

		Passenger passenger = passengerRepository.findById(passengerId)
				.orElseThrow(() -> new NotFoundException("Passenger not found."));

		for (PassengerActivity pa : activity.getPassengerActivity()) {
			if (pa.getPassenger().getId().compareTo(passenger.getId()) == 0) {
				throw new BadRequestException("User already signed up for this request!");
			}
		}

		if (activity.getSignedUp() == activity.getCapacity()) {
			throw new BadRequestException("Activity capacity Full");
		}

		if (passenger.getMembership() == Membership.STANDARD) {
			if (passenger.getBalance() < activity.getCost()) {
				throw new BadRequestException("insufficient balance");
			} else {
				finalPrice = activity.getCost();
				passenger.setBalance(passenger.getBalance() - finalPrice);
			}
		} else if (passenger.getMembership() == Membership.GOLD) {
			int discount = 10;
			finalPrice = activity.getCost() - ((activity.getCost() * discount) / 100);

			if (passenger.getBalance() < finalPrice) {
				throw new BadRequestException("insufficient balance");
			} else {
				passenger.setBalance(passenger.getBalance() - finalPrice);
			}
		}

		activity.setSignedUp(activity.getSignedUp() + 1);
		passengerRepository.save(passenger);
		activityRepository.save(activity);

		PassengerActivity pa = new PassengerActivity();
		pa.setId(new PassengerActivityKey(passenger.getId(), activity.getId()));
		pa.setActivity(activity);
		pa.setPassenger(passenger);
		pa.setPricePaid(finalPrice);
		passengerActivityRepository.save(pa);

	}
	

	@Override
	public List<ActivityDto> getAvailableActivites() {
		List<Activity> activites = activityRepository.findAvailableActivity();
		return ActivityMapper.toActivityDtoListForAvailableActivites(activites);
	}
}
