package com.project.hospital_managemnet_system_E4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.service.HospitalService;

@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	
	
	@PostMapping("/saveHospital")
	public Hospital saveHospital(@RequestBody Hospital Hospital) {
		return hospitalService.saveHospital(Hospital);
	}

	@PutMapping("/updateHospitalById")
	public Hospital updateHospitalById (@RequestParam int oldHospitalId,@RequestBody Hospital newHospital) {

		return hospitalService.updateHospitalById(oldHospitalId, newHospital);
	}

	@GetMapping("/fetchHospitalById")
	public Hospital fetchHospitalById(@RequestParam int HospitalId) {
		return hospitalService.fetchHospitalById(HospitalId);
	}

	@DeleteMapping("/deleteHospitalById")
	public Hospital deleteHospitalById(@RequestParam int HospitalId) {

		return hospitalService.deleteHospitalById(HospitalId);
	}

	@GetMapping("/fetchAllHospital")
	public List<Hospital> fetchAllHospital() {
		return hospitalService.fetchAllHospital();
	}
	

}
