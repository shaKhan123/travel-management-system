package com.demo.TravelManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.TravelManagement.entity.Passenger;

@Repository
public interface PassengerRepository  extends JpaRepository<Passenger, Long>{

}
