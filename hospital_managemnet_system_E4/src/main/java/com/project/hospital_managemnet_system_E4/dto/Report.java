package com.project.hospital_managemnet_system_E4.dto;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportId;
	private String reportName;
	private String reportType; // e.g., "Blood Test", "X-Ray", "MRI"
	private String description;
	private Date reportDate;
	private String reportStatus;

}
