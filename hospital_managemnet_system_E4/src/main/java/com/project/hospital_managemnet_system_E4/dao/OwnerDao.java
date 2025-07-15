package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.repo.OwnerRepo;

@Repository
public class OwnerDao {
	
	@Autowired
	OwnerRepo ownerRepo;
	
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {
		newOwner.setOwnerId(oldOwnerId) ;
	//	return ownerRepo.save(newOwner);
		return saveOwner(newOwner);
	}
	
	public Owner fetchOwnerById(int ownerId) {
		return ownerRepo.findById(ownerId).get();
	}
	
	public Owner deleteOwnerById(int ownerId) {
	//	Owner owner=ownerRepo.findById(ownerId).get();
		Owner owner=fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}
	
	public List<Owner> fetchAllOwner(){
		return ownerRepo.findAll();
	}

}
