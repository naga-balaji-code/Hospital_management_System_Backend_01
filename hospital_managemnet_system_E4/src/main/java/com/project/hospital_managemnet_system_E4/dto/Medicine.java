package com.project.hospital_managemnet_system_E4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicineId;
	private String medicineName;
	private double medicinePrice;
	private String medicineDose;
	private String medicineType;

}
