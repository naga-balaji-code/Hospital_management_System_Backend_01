package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.OwnerDao;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.repo.OwnerRepo;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	public Owner saveOwner(Owner owner) {
		return ownerDao.saveOwner(owner);
	}

	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {

		return ownerDao.updateOwnerById(oldOwnerId, newOwner);
	}

	public Owner fetchOwnerById(int ownerId) {
		return ownerDao.fetchOwnerById(ownerId);
	}

	public Owner deleteOwnerById(int ownerId) {

		return ownerDao.deleteOwnerById(ownerId);
	}

	public List<Owner> fetchAllOwner() {
		return ownerDao.fetchAllOwner();
	}
}
