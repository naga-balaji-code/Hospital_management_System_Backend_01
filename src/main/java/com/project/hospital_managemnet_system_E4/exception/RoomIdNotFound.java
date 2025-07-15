package com.project.hospital_managemnet_system_E4.exception;

public class RoomIdNotFound extends RuntimeException
{
	String message="Provided RoomId is Not Found";

	public String getMessage() {
		return message;
	}

}
