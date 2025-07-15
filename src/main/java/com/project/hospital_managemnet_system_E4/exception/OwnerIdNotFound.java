package com.project.hospital_managemnet_system_E4.exception;

public class OwnerIdNotFound extends RuntimeException
{
String message="Provided OwnerId is Not Found";

public String getMessage() {
	return message;
}


}
