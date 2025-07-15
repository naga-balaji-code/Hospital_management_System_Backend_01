package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.HospitalDao;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.exception.HospitalIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
@Service
public class HospitalService 
{
   @Autowired
   HospitalDao hospitalDao;
   
   
   @Autowired
  	ResponseStructure<Hospital> responseStructure;
  	   
 public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		responseStructure.setMessage("Suucessfully hospital created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(int oldHospitalId, Hospital newHospital) {
		responseStructure.setMessage("Suucessfully hospital Updated in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(hospitalDao.updateHospitalById(oldHospitalId, newHospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);

		//return hospitalDao.updateHospitalById(oldHospitalId, newHospital);
	}

	public ResponseEntity<ResponseStructure<Hospital>> fetchHospitalById(int hospitalId) {
		Hospital hospital=hospitalDao.fetchHospitalById(hospitalId);
		if(hospital!=null)
		{
		responseStructure.setMessage("Suucessfully hospital Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(hospitalDao.fetchHospitalById(hospitalId));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new HospitalIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int hospitalId) {
		responseStructure.setMessage("Suucessfully hospital deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(hospitalDao.deleteHospitalById(hospitalId));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		
	}
	public List<Hospital> fetchAllHospital() {
		return hospitalDao.fetchAllHospital();
	}
	
	public Hospital addingExistingBranchToExistingHospital(int hospitalId,int branchId)
	{
		return hospitalDao.addingExistingBranchToExistingHospital(hospitalId,branchId);
	}
	
	public Hospital addingNewBranchToExistingHospital(int hospitalId,Branch branch)
	{
		return hospitalDao.addingNewBranchToExistingHospital(hospitalId,branch);
		
	}
}

