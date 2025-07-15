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

import com.project.hospital_managemnet_system_E4.dao.OwnerDao;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.service.OwnerService;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;

	@PostMapping("/saveOwner")
	public Owner saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	@PutMapping("/updateOwnerById")
	public Owner updateOwnerById (@RequestParam int oldOwnerId,@RequestBody Owner newOwner) {

		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}

	@GetMapping("/fetchOwnerById")
	public Owner fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}

	@DeleteMapping("/deleteOwnerById")
	public Owner deleteOwnerById(@RequestParam int ownerId) {

		return ownerService.deleteOwnerById(ownerId);
	}

	@GetMapping("/fetchAllOwner")
	public List<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}
}
