package com.demo.TravelManagement.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;

import org.springframework.stereotype.Repository;

@Repository
public class TravelPackageRepositoryImpl {

	@PersistenceContext
    private EntityManager entityManager;
	
	public List<Tuple> printDestinations() {

		String sql1 = "select tp.name, des from TravelPackage tp join  tp.destinations des where tp.id = :tpId";
		
		List<Tuple> data = entityManager.createQuery(
			    sql1, Tuple.class)
			.setParameter( "tpId", 1L )
			.getResultList();
		
		return data;
		
	}
	
	public List<Tuple> printPassengers() {

		String sql1 = "select tp.name, tp.passengerCapacity, pas from TravelPackage tp join tp.passengers pas where tp.id = :tpId";
		
		List<Tuple> data = entityManager.createQuery(
			    sql1, Tuple.class)
			.setParameter( "tpId", 1L )
			.getResultList();
		
		return data;
		
	}
	
}
