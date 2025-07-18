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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.service.EncounterService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@RestController
//@CrossOrigin(origins = "http://localhost:5176")
@CrossOrigin(origins = "*") 
public class EncounterController
{

	@Autowired
	EncounterService encounterService;
	@PostMapping("/saveEncounter")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter)
	{
		return encounterService.saveEncounter(encounter);
	}


	@PutMapping("/updateEncounterbyId")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounterById (@RequestParam int oldEncounterId,@RequestBody Encounter newEncounter) {

		return encounterService.updateEncounterById(oldEncounterId, newEncounter);
	}

	@GetMapping("/fetchEncounterById")
	public ResponseEntity<ResponseStructure<Encounter>> fetchEncounterById(@RequestParam int encounterId) {
		return encounterService.fetchEncounterById(encounterId);
	}

	@DeleteMapping("/deleteEncounterById")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounterById(@RequestParam int encounterId) {

		return encounterService.deleteEncounterById(encounterId);
	}

	@GetMapping("/fetchAllEncounter")
	public List<Encounter> fetchAllEncounter() {
		return encounterService.fetchAllEncounter();
	}
}
