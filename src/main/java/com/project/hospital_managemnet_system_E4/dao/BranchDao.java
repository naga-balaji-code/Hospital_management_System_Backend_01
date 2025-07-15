package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.exception.AddressIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.BranchHeadIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.BranchIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.BranchRepo;
@Repository
public class BranchDao {
	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	EmployeeDao employeedao;
	
	@Autowired
	BranchHeadDao branchHeadDao;
	
	@Autowired
	AddressDao addressdao;
	
	@Autowired
	PatientDao patientdao;
	
	public Branch saveBranch(Branch branch)
	{
		return branchRepo.save(branch);
	}
	public Branch updateBranchById(int oldBranchId ,Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		//	return BranchRepo.save(newBranch);
		return saveBranch(newBranch);
	}
	
	public Branch fetchBranchById(int branchId){
		Optional<Branch> branch=branchRepo.findById(branchId);
		  if(branch.isEmpty()) {
			  return null;
		  }
		  else {
			  return branch.get();
		  }
	}
	
	public Branch deleteBranchById(int branchId){
	//	Branch Branch=BranchRepo.findById(BranchId).get();
		Branch branch=fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	
	public List<Branch> fetchAllBranch(){
		return branchRepo.findAll();
	}
	
	
	
	//Branch-------Employee

	public Branch addingExistingEmployeeToExistingBranch(int branchId,int employeeId)
	{
		Branch branch=fetchBranchById(branchId);
		Employee employee=employeedao.fetchEmployeeById(employeeId);
		List<Employee> list=branch.getEmployees();
		list.add(employee);
		branch.setEmployees(list);
		//	return ownerRepo.save(newOwner);
		return saveBranch(branch);
	}
	
	public Branch addingNewEmployeeToExistingBranch(int branchId,Employee employee)
	{
		Branch branch=fetchBranchById(branchId);
		List<Employee> list=branch.getEmployees();
		list.add(employee);
		branch.setEmployees(list);
		//	return ownerRepo.save(newOwner);
		return saveBranch(branch);
	}
	
	
	
	//Branch---->BranchHead
	
	
	public Branch addingExistingBranchHeadToExistingBranch(int branchHeadId,int branchId)
	{
		Branch branch=fetchBranchById(branchId);
		BranchHead branchHead=branchHeadDao.fetchBranchHeadById(branchHeadId);
		branch.setBranchHead(branchHead);
		//	return BranchRepo.save(newBranch);
		return saveBranch(branch);
	}
	
	public Branch addingNewBranchHeadToExistingBranch(int BranchId,BranchHead branchHead)
	{
		Branch Branch=fetchBranchById(BranchId);
		Branch.setBranchHead(branchHead);
		return saveBranch(Branch);
	}
	
	
	
	//Branch------>Address
	
	public Branch addingExistingAddressToExistingBranch(int addressId,int branchId)
	{
		Branch branch=fetchBranchById(branchId);
		Address address=addressdao.fetchAddressById(addressId);
		branch.setAddress(address);
		//	return branchRepo.save(newBranch);
		return saveBranch(branch);
	}
	
	
	public Branch addingNewAddressToExistingBranch(int branchId,Address address)
	{
		Branch branch=fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	
	//Branch----->>>Patients
	
	public Branch addingExistingPatientToExistingBranch(int branchId,int patientId)
	{
		Branch branch=fetchBranchById(branchId);
		Patient patient=patientdao.fetchPatientById(patientId);
		List<Patient> list=branch.getPatients();
		list.add(patient);
		branch.setPatients(list);
		//	return ownerRepo.save(newOwner);
		return saveBranch(branch);
	}
	
	
	public Branch addingNewPatientToExistingBranch(int branchId,Patient newPatient)
	{
		Branch branch=fetchBranchById(branchId);
		List<Patient> list=branch.getPatients();
		list.add(newPatient);
		branch.setPatients(list);
		//	return ownerRepo.save(newOwner);
		return saveBranch(branch);
	}
	

}
