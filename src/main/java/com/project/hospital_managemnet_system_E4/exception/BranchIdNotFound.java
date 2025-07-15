package com.project.hospital_managemnet_system_E4.exception;

public class BranchIdNotFound extends RuntimeException
{

	String message="Provided BranchId is Not Found";

	public String getMessage() {
		return message;
	}

	
}
