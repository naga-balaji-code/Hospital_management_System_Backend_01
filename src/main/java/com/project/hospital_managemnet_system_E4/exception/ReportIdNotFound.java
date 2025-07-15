package com.project.hospital_managemnet_system_E4.exception;

public class ReportIdNotFound extends RuntimeException
{
	String message="Provided ReportId is Not Found";

	public String getMessage() {
		return message;
	}

}
