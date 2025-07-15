package com.project.hospital_managemnet_system_E4.exception;

public class MedicineIdNotFound extends RuntimeException
{
	String message="Provided MedicineId is Not Found";

	public String getMessage() {
		return message;
	}

}
