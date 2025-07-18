package com.project.hospital_managemnet_system_E4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.service.HospitalService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@RestController
//@CrossOrigin(origins = "*") 
@CrossOrigin(origins = "*") 

public class HospitalController 
{
@Autowired
HospitalService hospitalservice;

@PostMapping("/saveHospital")
	public ResponseEntity<ResponseStructure<Hospital>>saveHospital(@RequestBody Hospital hospital)
	{
		return hospitalservice.saveHospital(hospital);
	}
	
	
	@PutMapping("/updateHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById (@RequestParam int oldHospitalId,@RequestBody Hospital newHospital) {
	
		return hospitalservice.updateHospitalById(oldHospitalId, newHospital);
	}
	
	@GetMapping("/fetchHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> fetchHospitalById(@RequestParam int hospitalId) {
		return hospitalservice.fetchHospitalById(hospitalId);
	}
	
	@DeleteMapping("/deleteHospitalById")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(@RequestParam int hospitalId) {
	
		return hospitalservice.deleteHospitalById(hospitalId);
	}
	
	@GetMapping("/fetchAllHospital")
	public List<Hospital> fetchAllHospital() {
		return hospitalservice.fetchAllHospital();
	}
	
	@PutMapping("/addingExistingBranchToExistingHospital")
	public Hospital addingExistingBranchToExistingHospital(int hospitalId,int branchId)
	{
		return hospitalservice.addingExistingBranchToExistingHospital(hospitalId,branchId);
	}
	@PutMapping("/addingNewBranchToExistingHospital")
	public Hospital addingNewBranchToExistingHospital(int hospitalId,Branch branch)
	{
		return hospitalservice.addingNewBranchToExistingHospital(hospitalId,branch);
		
	}
	}
	
