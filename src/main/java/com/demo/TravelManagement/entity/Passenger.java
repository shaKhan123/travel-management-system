package com.demo.TravelManagement.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "passenger")
public class Passenger {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private int passengerNumber;

	@Column
	private int balance;

	@Column
	private Membership membership;

	@OneToMany(mappedBy = "passenger")
	private Set<PassengerActivity> passengerActivity;

}
