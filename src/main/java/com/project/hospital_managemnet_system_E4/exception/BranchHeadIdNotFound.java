package com.project.hospital_managemnet_system_E4.exception;

public class BranchHeadIdNotFound extends RuntimeException
{

	String message="Provided BranchHeadId is Not Found";

	public String getMessage() {
		return message;
	}

	
}
