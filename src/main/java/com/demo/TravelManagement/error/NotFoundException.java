package com.demo.TravelManagement.error;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 2181174869331082282L;

	public NotFoundException(String message) {
		super(message);
	}
}
