package com.demo.TravelManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.TravelManagement.entity.PassengerActivity;
import com.demo.TravelManagement.entity.PassengerActivityKey;
@Repository
public interface PassengerActivityRepository  extends JpaRepository<PassengerActivity, PassengerActivityKey>{
	
}
