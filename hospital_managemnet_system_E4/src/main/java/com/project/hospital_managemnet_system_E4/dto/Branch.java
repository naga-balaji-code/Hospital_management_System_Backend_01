package com.project.hospital_managemnet_system_E4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchId;
	private String branchName;
	private long branchPhone;
	private String branchEmail;
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public long getBranchPhone() {
		return branchPhone;
	}
	public void setBranchPhone(long branchPhone) {
		this.branchPhone = branchPhone;
	}
	public String getBranchEmail() {
		return branchEmail;
	}
	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

}
