package com.project.hospital_managemnet_system_E4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class BranchHead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchHeadId;
	private String branchHeadName;
	private String branchHeadEmail;
	private long branchHeadPhone;
	private double branchHeadSalary;

}
