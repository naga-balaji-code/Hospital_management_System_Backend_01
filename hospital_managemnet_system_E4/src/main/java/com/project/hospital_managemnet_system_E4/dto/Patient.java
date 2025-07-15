package com.project.hospital_managemnet_system_E4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String patientName;
	private int patientAge;
	private String patientGender;
	private String patientEmail;
	private long patientPhone;

}
