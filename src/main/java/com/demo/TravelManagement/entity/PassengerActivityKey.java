package com.demo.TravelManagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PassengerActivityKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "passenger_id")
    Long passengerId;

    @Column(name = "activity_id")
    Long activityId;

    public PassengerActivityKey() {}
	public PassengerActivityKey(Long passengerId, Long activityId) {
		super();
		this.passengerId = passengerId;
		this.activityId = activityId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityId == null) ? 0 : activityId.hashCode());
		result = prime * result + ((passengerId == null) ? 0 : passengerId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerActivityKey other = (PassengerActivityKey) obj;
		if (activityId == null) {
			if (other.activityId != null)
				return false;
		} else if (!activityId.equals(other.activityId))
			return false;
		if (passengerId == null) {
			if (other.passengerId != null)
				return false;
		} else if (!passengerId.equals(other.passengerId))
			return false;
		return true;
	}
    
    
    
}
