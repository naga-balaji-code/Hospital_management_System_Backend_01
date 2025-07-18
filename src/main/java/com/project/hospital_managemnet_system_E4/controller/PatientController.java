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

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.service.PatientService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@RestController
//@CrossOrigin(origins = "http://localhost:5176")
@CrossOrigin(origins = "*") 
public class PatientController 
{
	@Autowired
	PatientService patientService;

	@PostMapping("/savePatient")
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	@PutMapping("/updatePatientById")
	public ResponseEntity<ResponseStructure<Patient>> updatePatientById (@RequestParam int oldPatientId,@RequestBody Patient newPatient) {

		return patientService.updatePatientById(oldPatientId, newPatient);
	}

	@GetMapping("/fetchPatientById")
	public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(@RequestParam int patientId) {
		return patientService.fetchPatientById(patientId);
	}

	@DeleteMapping("/deletePatientById")
	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(@RequestParam int patientId) {

		return patientService.deletePatientById(patientId);
	}

	@GetMapping("/fetchAllPatient")
	public List<Patient> fetchAllPatient() {
		return patientService.fetchAllPatient();
	}
		
		
	//Patient------>>>>>Room
		
	@PutMapping("/addingExistingRoomToExistingPatient")
	public Patient addingExistingRoomToExistingPatient(@RequestParam int roomId,@RequestParam int patientId)
	{
		return patientService.addingExistingRoomToExistingPatient(roomId, patientId);
	}
	@PutMapping("/addingNewRoomToExistingPatient")
	public Patient addingNewRoomToExistingPatient(@RequestParam int patientId,@RequestBody Room room)
	{
			return patientService.addingNewRoomToExistingPatient(patientId,room);
	}


   //Patient------>>>>>Report

	@PutMapping("/addingExistingReportToExistingPatient")
	public Patient addingExistingReportToExistingPatient(@RequestParam int reportId,@RequestParam int patientId)
	{
		return patientService.addingExistingReportToExistingPatient(reportId, patientId);
	}
	@PutMapping("/addingNewReportToExistingPatient")
	public Patient addingNewReportToExistingPatient(@RequestParam int patientId,@RequestBody Report report)
	{
			return patientService.addingNewReportToExistingPatient(patientId,report);
	}

	//Patient------>>>>>Medicine
	
	@PutMapping("/addingExistingMedicineToExistingPatient")
	public Patient addingExistingMedicineToExistingPatient(@RequestParam int medicineId,@RequestParam int patientId)
	{
		return patientService.addingExistingMedicineToExistingPatient(medicineId, patientId);
	}
	@PutMapping("/addingNewMedicineToExistingPatient")
	public Patient addingNewMedicineToExistingPatient(@RequestParam int patientId,@RequestBody Medicine medicine)
	{
			return patientService.addingNewMedicineToExistingPatient(patientId,medicine);
	}

	
	//Patient------>>>>>Encounter
	
	@PutMapping("/addingExistingEncounterToExistingPatient")
	public Patient addingExistingEncounterToExistingPatient(@RequestParam int encounterId,@RequestParam int patientId)
	{
		return patientService.addingExistingEncounterToExistingPatient(encounterId, patientId);
	}
	@PutMapping("/addingNewEncounterToExistingPatient")
	public Patient addingNewEncounterToExistingPatient(@RequestParam int patientId,@RequestBody Encounter encounter)
	{
			return patientService.addingNewEncounterToExistingPatient(patientId,encounter);
	}
	

	//Patient------>>>>>Payment
	
	@PutMapping("/addingExistingPaymentToExistingPatient")
	public Patient addingExistingPaymentToExistingPatient(@RequestParam int paymentId,@RequestParam int patientId)
	{
		return patientService.addingExistingPaymentToExistingPatient(paymentId, patientId);
	}
	@PutMapping("/addingNewPaymentToExistingPatient")
	public Patient addingNewPaymentToExistingPatient(@RequestParam int patientId,@RequestBody Payment payment)
	{
			return patientService.addingNewPaymentToExistingPatient(patientId,payment);
	}
	
	
	
}
