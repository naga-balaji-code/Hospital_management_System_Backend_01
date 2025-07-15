package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.HospitalDao;
import com.project.hospital_managemnet_system_E4.dao.HospitalDao;
import com.project.hospital_managemnet_system_E4.dto.Hospital;

@Service
public class HospitalService {
	@Autowired
	HospitalDao hospitalDao;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalDao.saveHospital(hospital);
	}

	public Hospital updateHospitalById(int oldHospitalId, Hospital newHospital) {

		return hospitalDao.updateHospitalById(oldHospitalId, newHospital);
	}

	public Hospital fetchHospitalById(int HospitalId) {
		return hospitalDao.fetchHospitalById(HospitalId);
	}

	public Hospital deleteHospitalById(int HospitalId) {

		return hospitalDao.deleteHospitalById(HospitalId);
	}

	public List<Hospital> fetchAllHospital() {
		return hospitalDao.fetchAllHospital();
	}

	
}
