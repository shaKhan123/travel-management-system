package com.demo.TravelManagement.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class PassengerActivity {

	    @EmbeddedId
	    private PassengerActivityKey id = new PassengerActivityKey();
	 
	    @ManyToOne
	    @MapsId("passenger_id")
	    private Passenger passenger;
	 
	    @ManyToOne
	    @MapsId("activity_id")
	    private Activity activity;
	 
	    private Integer pricePaid;
	    
}
