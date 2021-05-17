package com.demo.TravelManagement.error;

public class BadRequestException extends Exception{

	private static final long serialVersionUID = -4509674816148828922L;

	public BadRequestException(String message) {
		super(message);
	}
}
