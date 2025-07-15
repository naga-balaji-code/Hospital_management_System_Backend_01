package com.project.hospital_managemnet_system_E4.exception;

public class PaymentIdNotFound extends RuntimeException
{
	String message="Provided PaymentId is Not Found";

	public String getMessage() {
		return message;
	}

}
