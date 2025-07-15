package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Encounter;
import com.project.hospital_managemnet_system_E4.exception.AddressIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.EncounterIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.EncounterRepo;

@Repository
public class EncounterDao 
{
	@Autowired
	EncounterRepo encounterRepo;
	
	public Encounter saveEncounter(Encounter encounter)
	{
		return encounterRepo.save(encounter);
	}
	public Encounter updateEncounterById(int oldEncounterId,Encounter newEncounter) {
		newEncounter.setEncounterId(oldEncounterId);
		//	return BranchRepo.save(newBranch);
		return saveEncounter(newEncounter);
	}
	
	public Encounter fetchEncounterById(int encounterId) {
		Optional<Encounter> encounter=encounterRepo.findById(encounterId);
		  if(encounter.isEmpty()) {
			  return null;
		  }
		  else {
			  return encounter.get();
		  }
	}
	
	public Encounter deleteEncounterById(int encounterId) {
	//	Branch Branch=BranchRepo.findById(BranchId).get();
		Encounter encounter=fetchEncounterById(encounterId);
		encounterRepo.delete(encounter);
		return encounter;
	}
	
	public List<Encounter> fetchAllEncounter(){
		return encounterRepo.findAll();
	}
}
