package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.dto.Room;
import com.project.hospital_managemnet_system_E4.exception.PatientIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.PatientRepo;
@Repository
public class PatientDao
{
	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	ReportDao reportDao;
	
	@Autowired
	MedicineDao medicineDao;
	
	@Autowired
	EncounterDao encounterDao;
	
	@Autowired
	PaymentDao paymentDao;
	
	
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	public Patient updatePatientById(int oldPatientId, Patient newPatient) {
		newPatient.setPatientId(oldPatientId);
	//	return PatientRepo.save(newPatient);
		return savePatient(newPatient);
	}
	
	public Patient fetchPatientById(int patientId) {
		Optional<Patient> patient=patientRepo.findById(patientId);
		  if(patient.isEmpty()) {
			  return null;
		  }
		  else {
			  return patient.get();
		  }
		  }
	
	public Patient deletePatientById(int patientId) {
	//	Patient Patient=PatientRepo.findById(PatientId).get();
		Patient patient=fetchPatientById(patientId);
		patientRepo.delete(patient);
		return patient;
	}
	
	public List<Patient> fetchAllPatient(){
		return patientRepo.findAll();
	}
	
	
	//Patient------>Room
	
		public Patient addingExistingRoomToExistingPatient(int roomId,int patientId)
		{
			Patient patient=fetchPatientById(patientId);
			Room room=roomDao.fetchRoomById(roomId);
			patient.setRoom(room);
			//	return patientRepo.save(newPatient);
			return savePatient(patient);
		}
		
		
		public Patient addingNewRoomToExistingPatient(int patientId,Room room)
		{
			Patient patient=fetchPatientById(patientId);
			patient.setRoom(room);
			return savePatient(patient);
		}
		
		
		//Patient------>Report
		
			public Patient addingExistingReportToExistingPatient(int reportId,int patientId)
			{
				Patient patient=fetchPatientById(patientId);
				Report report=reportDao.fetchReportById(reportId);
				patient.setReport(report);
				//	return patientRepo.save(newPatient);
				return savePatient(patient);
			}
			
			
			public Patient addingNewReportToExistingPatient(int patientId,Report report)
			{
				Patient patient=fetchPatientById(patientId);
				patient.setReport(report);
				return savePatient(patient);
			}
		
		//Patient----->>>Medicine
		
		public Patient addingExistingMedicineToExistingPatient(int patientId,int medicineId)
		{
			Patient patient=fetchPatientById(patientId);
			Medicine medicine=medicineDao.fetchMedicineById(medicineId);
			List<Medicine> list=patient.getMedicines();
			list.add(medicine);
			patient.setMedicines(list);
			//	return ownerRepo.save(newOwner);
			return savePatient(patient);
		}
		public Patient addingNewMedicineToExistingPatient(int patientId,Medicine newMedicine)
		{
			Patient patient=fetchPatientById(patientId);
			List<Medicine> list=patient.getMedicines();
			list.add(newMedicine);
			patient.setMedicines(list);
			//	return ownerRepo.save(newOwner);
			return savePatient(patient);
		}
		
		
		//Patient----->>>Encounter
		
		public Patient addingExistingEncounterToExistingPatient(int patientId,int encounterId)
		{
			Patient patient=fetchPatientById(patientId);
			Encounter encounter=encounterDao.fetchEncounterById(encounterId);
			List<Encounter> list=patient.getEncounters();
			list.add(encounter);
			patient.setEncounters(list);
			//	return ownerRepo.save(newOwner);
			return savePatient(patient);
		}
		public Patient addingNewEncounterToExistingPatient(int patientId,Encounter newEncounter)
		{
			Patient patient=fetchPatientById(patientId);
			List<Encounter> list=patient.getEncounters();
			list.add(newEncounter);
			patient.setEncounters(list);
			//	return ownerRepo.save(newOwner);
			return savePatient(patient);
		}
		
		
		//Patient----->>>Payment
		
		public Patient addingExistingPaymentToExistingPatient(int patientId,int paymentId)
		{
	      	Patient patient=fetchPatientById(patientId);
			Payment payment=paymentDao.fetchPaymentById(paymentId);
			List<Payment> list=patient.getPayments();
			list.add(payment);
			patient.setPayments(list);
			//	return ownerRepo.save(newOwner);
			return savePatient(patient);
		}
		public Patient addingNewPaymentToExistingPatient(int patientId,Payment newPayment)
		{
			Patient patient=fetchPatientById(patientId);
			List<Payment> list=patient.getPayments();
			list.add(newPayment);
			patient.setPayments(list);
			//	return ownerRepo.save(newOwner);
			return savePatient(patient);
		}
	
	
}
