package com.project.hospital_managemnet_system_E4.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;
	private String hospitalName;
	private long hospitalPhone;
	private String hospitalEmail;
	private String hospitalGst;
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public long getHospitalPhone() {
		return hospitalPhone;
	}
	public void setHospitalPhone(long hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}
	public String getHospitalEmail() {
		return hospitalEmail;
	}
	public void setHospitalEmail(String hospitalEmail) {
		this.hospitalEmail = hospitalEmail;
	}
	public String getHospitalGst() {
		return hospitalGst;
	}
	public void setHospitalGst(String hospitalGst) {
		this.hospitalGst = hospitalGst;
	}

}
