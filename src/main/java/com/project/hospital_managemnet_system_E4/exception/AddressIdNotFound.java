package com.project.hospital_managemnet_system_E4.exception;

public class AddressIdNotFound extends RuntimeException
{
	String message="Provided AddressId is Not Found";

	public String getMessage(){
		return message;
	}

}
