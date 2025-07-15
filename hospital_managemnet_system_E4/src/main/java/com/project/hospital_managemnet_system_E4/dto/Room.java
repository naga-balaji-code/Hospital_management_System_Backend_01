package com.project.hospital_managemnet_system_E4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	private int roomNumber;
	private String roomPrice;
	private String roomType;
	private int roomCapacity;

}
