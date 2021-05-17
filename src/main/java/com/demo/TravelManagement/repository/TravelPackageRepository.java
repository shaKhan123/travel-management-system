package com.demo.TravelManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.TravelManagement.entity.TravelPackage;

@Repository
public interface TravelPackageRepository  extends JpaRepository<TravelPackage, Long>{

	public List<TravelPackage> findAll();
	
	 @Query("SELECT tp FROM TravelPackage tp JOIN FETCH tp.destinations WHERE tp.id = (:id)")
	 public TravelPackage findByTravelPackageEagerly(@Param("id") Long id);
	
}
