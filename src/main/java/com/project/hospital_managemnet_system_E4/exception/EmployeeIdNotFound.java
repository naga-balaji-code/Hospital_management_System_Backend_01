package com.project.hospital_managemnet_system_E4.exception;

public class EmployeeIdNotFound extends RuntimeException
{
	String message="Provided EmployeeId is Not Found";

	public String getMessage() {
		return message;
	}
}
