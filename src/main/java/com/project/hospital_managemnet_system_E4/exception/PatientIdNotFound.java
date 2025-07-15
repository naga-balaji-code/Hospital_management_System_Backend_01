package com.project.hospital_managemnet_system_E4.exception;

public class PatientIdNotFound extends RuntimeException
{
	String message="Provided PatientId is Not Found";

	public String getMessage() {
		return message;
	}

}
