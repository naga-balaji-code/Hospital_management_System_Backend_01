package com.project.hospital_managemnet_system_E4.exception;

public class HospitalIdNotFound extends RuntimeException
{

	String message="Provided HospitalId is Not Found";

	public String getMessage() {
		return message;
	}

	
}
