package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.exception.AddressIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.HospitalIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.HospitalRepo;

@Repository
public class HospitalDao {
	
	@Autowired
	HospitalRepo hospitalRepo;
	
	@Autowired
	BranchDao branchdao;
	
	public Hospital saveHospital(Hospital hospital)
	{
		return hospitalRepo.save(hospital);
	}
	public Hospital updateHospitalById(int oldHospitalId,Hospital newHospital) {
		newHospital.setHospitalId(oldHospitalId);
		//	return hospitalRepo.save(newhospital);
		return saveHospital(newHospital);
	}
	
	public Hospital fetchHospitalById(int hospitalId) {
		Optional<Hospital> hospital=hospitalRepo.findById(hospitalId);
		  if(hospital.isEmpty()) {
			  return null;
		  }
		  else {
			  return hospital.get();
		  }
		  
	}
	
	public Hospital deleteHospitalById(int HospitalId) {
	//	Hospital Hospital=HospitalRepo.findById(HospitalId).get();
		Hospital hospital=fetchHospitalById(HospitalId);
		hospitalRepo.delete(hospital);
		return hospital;
	}
	
	public List<Hospital> fetchAllHospital(){
		return hospitalRepo.findAll();
	}
	
	public Hospital addingExistingBranchToExistingHospital(int hospitalId,int branchId)
	{
		Hospital hospital=fetchHospitalById(hospitalId);
		Branch branch=branchdao.fetchBranchById(branchId);
		List<Branch> list=hospital.getBranches();
		list.add(branch);
		hospital.setBranches(list);
		//	return ownerRepo.save(newOwner);
		return saveHospital(hospital);
	}
	
	public Hospital addingNewBranchToExistingHospital(int hospitalId,Branch branch)
	{
		Hospital hospital=fetchHospitalById(hospitalId);
		List<Branch> list=hospital.getBranches();
		list.add(branch);
		hospital.setBranches(list);
		//	return ownerRepo.save(newOwner);
		return saveHospital(hospital);
	}
}
