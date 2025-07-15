package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.OwnerDao;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;
	
	
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setMessage("Suucessfully owner created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(int oldOwnerId, Owner newOwner) {
		responseStructure.setMessage("Suucessfully owner Updated in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.CREATED);

		//return ownerDao.updateOwnerById(oldOwnerId, newOwner);
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null)
		{
		responseStructure.setMessage("Suucessfully owner Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new OwnerIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		responseStructure.setMessage("Suucessfully owner deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure,HttpStatus.OK);
		
	}

	public List<Owner> fetchAllOwner() {
		return ownerDao.fetchAllOwner();
	}
	
	public Owner addingExistingHospitalToExistingOwner(int hospitalId,int ownerId)
	{
		return ownerDao.addingExistingHospitalToExistingOwner(hospitalId, ownerId);
	}
	public Owner addingNewHospitalToExistingOwner(int ownerId,Hospital hospital)
	{
		return ownerDao.addingNewHospitalToExistingOwner(ownerId,hospital);
	}

}
