package com.project.hospital_managemnet_system_E4.exception;

public class EncounterIdNotFound extends RuntimeException
{

	String message="Provided EncounterId is Not Found";

	public String getMessage() {
		return message;
	}

	
}
