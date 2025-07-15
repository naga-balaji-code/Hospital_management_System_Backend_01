package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.repo.HospitalRepo;
@Repository
public class HospitalDao {
	@Autowired
	HospitalRepo hospitalrepo;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalrepo.save(hospital);
	}
	public Hospital updateHospitalById(int oldHospitalId, Hospital newHospital) {
		newHospital.setHospitalId(oldHospitalId);
	//	return HospitalRepo.save(newHospital);
		return saveHospital(newHospital);
	}
	
	public Hospital fetchHospitalById(int HospitalId) {
		return hospitalrepo.findById(HospitalId).get();
	}
	
	public Hospital deleteHospitalById(int HospitalId) {
	//	Hospital Hospital=HospitalRepo.findById(HospitalId).get();
		Hospital Hospital=fetchHospitalById(HospitalId);
		hospitalrepo.delete(Hospital);
		return Hospital;
	}
	
	public List<Hospital> fetchAllHospital(){
		return hospitalrepo.findAll();
	}


}
