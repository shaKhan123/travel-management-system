package com.demo.TravelManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.TravelManagement.entity.Activity;

@Repository
public interface ActivityRepository  extends JpaRepository<Activity, Long>{

	@Query("select a from Activity a where a.signedUp < a.capacity")
	List<Activity> findAvailableActivity();

}