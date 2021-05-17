package com.demo.TravelManagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "travelPackage")
public class TravelPackage {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String passengerCapacity;	
	
	@OneToMany(mappedBy = "travelPackage")
	private List<Destination> destinations;
	
	
	@OneToMany(cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JoinColumn(name = "travelPackage_id")
	private List<Passenger> passengers;

}
