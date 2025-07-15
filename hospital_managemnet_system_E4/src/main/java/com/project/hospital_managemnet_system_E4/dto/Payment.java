package com.project.hospital_managemnet_system_E4.dto;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String paymentType;
	private double paymentAmount;
	private String paymentStatus;
	private Date paymentDate;
	private Time paymentTime;

}
