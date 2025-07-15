package com.project.hospital_managemnet_system_E4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private long employeePhone;
	private double employeeSalary;
	private String employeeRole;

}
