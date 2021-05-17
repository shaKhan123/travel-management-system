package com.demo.TravelManagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "destination")
public class Destination {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@ToString.Exclude
	@OneToMany(mappedBy="destination", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Activity> activities;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="travelPackage_id")
    private TravelPackage travelPackage;
}
