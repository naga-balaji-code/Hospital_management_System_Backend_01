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

import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.service.MedicineService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@RestController
//@CrossOrigin(origins = "http://localhost:5176")
@CrossOrigin(origins = "*") 
public class MedicineController 
{
	@Autowired
	MedicineService medicineService;
	@PostMapping("/saveMedicine")
	public ResponseEntity<ResponseStructure<Medicine>> saveMedicine(@RequestBody Medicine medicine)
	{
		return medicineService.saveMedicine(medicine);
	}


	@PutMapping("/updateMedicineById")
	public ResponseEntity<ResponseStructure<Medicine>> updateMedicineById (@RequestParam int oldMedicineId,@RequestBody Medicine newMedicine) {

		return medicineService.updateMedicineById(oldMedicineId, newMedicine);
	}

	@GetMapping("/fetchMedicineById")
	public ResponseEntity<ResponseStructure<Medicine>> fetchMedicineById(@RequestParam int medicineId) {
		return medicineService.fetchMedicineById(medicineId);
	}

	@DeleteMapping("/deleteMedicineById")
	public ResponseEntity<ResponseStructure<Medicine>> deleteMedicineById(@RequestParam int medicineId) {

		return medicineService.deleteMedicineById(medicineId);
	}

	@GetMapping("/fetchAllMedicine")
	public List<Medicine> fetchAllMedicine() {
		return medicineService.fetchAllMedicine();
	}
}
