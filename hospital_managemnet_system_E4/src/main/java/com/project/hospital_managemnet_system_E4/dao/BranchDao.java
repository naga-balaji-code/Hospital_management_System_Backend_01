package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.repo.BranchRepo;
import com.project.hospital_managemnet_system_E4.repo.HospitalRepo;
@Repository
public class BranchDao {
	@Autowired
	BranchRepo Branchrepo;
	
	public Branch saveBranch(Branch Branch) {
		return Branchrepo.save(Branch);
	}
	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
	//	return BranchRepo.save(newBranch);
		return saveBranch(newBranch);
	}
	
	public Branch fetchBranchById(int BranchId) {
		return Branchrepo.findById(BranchId).get();
	}
	
	public Branch deleteBranchById(int BranchId) {
	//	Branch Branch=BranchRepo.findById(BranchId).get();
		Branch Branch=fetchBranchById(BranchId);
		Branchrepo.delete(Branch);
		return Branch;
	}
	
	public List<Branch> fetchAllBranch(){
		return Branchrepo.findAll();
	}


}
