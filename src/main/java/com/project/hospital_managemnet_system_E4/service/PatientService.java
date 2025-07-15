package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.PatientDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.exception.PatientIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class PatientService 
{
	@Autowired
	PatientDao patientDao;
	 @Autowired
	ResponseStructure<Patient> responseStructure;
		   
 public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient) {
		responseStructure.setMessage("Suucessfully patient created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(patientDao.savePatient(patient));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Patient>> updatePatientById(int oldPatientId, Patient newPatient) {
		responseStructure.setMessage("Suucessfully patient Updated in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(patientDao.updatePatientById(oldPatientId, newPatient));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.CREATED);

		//return patientDao.updatePatientById(oldPatientId, newPatient);
	}

	public ResponseEntity<ResponseStructure<Patient>> fetchPatientById(int patientId) {
		Patient patient=patientDao.fetchPatientById(patientId);
		if(patient!=null)
		{
		responseStructure.setMessage("Suucessfully patient Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(patientDao.fetchPatientById(patientId));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new PatientIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Patient>> deletePatientById(int patientId) {
		responseStructure.setMessage("Suucessfully patient deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(patientDao.deletePatientById(patientId));
		return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.OK);
		
	}
	public List<Patient> fetchAllPatient() {
		return patientDao.fetchAllPatient();
	}
	
	
	
	//Patient---->>>>Room
	
	public Patient addingExistingRoomToExistingPatient(int roomId,int patientId)
    {
		return patientDao.addingExistingRoomToExistingPatient(roomId, patientId);
	}
	
	public Patient addingNewRoomToExistingPatient(int patientId,Room room)
	{
		return patientDao.addingNewRoomToExistingPatient(patientId,room);
	}
	
	
	
	//Patient---->>>>Report
	
	public Patient addingExistingReportToExistingPatient(int reportId,int patientId)
	 {
		return patientDao.addingExistingReportToExistingPatient(reportId, patientId);
     }
		
	public Patient addingNewReportToExistingPatient(int patientId,Report report)
    {
			return patientDao.addingNewReportToExistingPatient(patientId,report);
	}
		
		
	//Patient---->>>>Medicine
	
	public Patient addingExistingMedicineToExistingPatient(int medicineId,int patientId)
	   {
			return patientDao.addingExistingMedicineToExistingPatient(medicineId, patientId);
		}
		
   public Patient addingNewMedicineToExistingPatient(int patientId,Medicine medicine)
		{
			return patientDao.addingNewMedicineToExistingPatient(patientId,medicine);
		}
	
   
 //Patient---->>>>Encounter
	
 	public Patient addingExistingEncounterToExistingPatient(int medicineId,int patientId)
 	   {
 			return patientDao.addingExistingEncounterToExistingPatient(medicineId, patientId);
 		}
 		
    public Patient addingNewEncounterToExistingPatient(int patientId,Encounter medicine)
 		{
 			return patientDao.addingNewEncounterToExistingPatient(patientId,medicine);
 		}
	
    
  //Patient---->>>>Payment
	
   	public Patient addingExistingPaymentToExistingPatient(int medicineId,int patientId)
   	   {
   			return patientDao.addingExistingPaymentToExistingPatient(medicineId, patientId);
   		}
   		
      public Patient addingNewPaymentToExistingPatient(int patientId,Payment medicine)
   		{
   			return patientDao.addingNewPaymentToExistingPatient(patientId,medicine);
   		}
	
}
