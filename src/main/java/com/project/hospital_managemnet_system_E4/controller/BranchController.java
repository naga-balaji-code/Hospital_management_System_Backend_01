package com.project.hospital_managemnet_system_E4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.service.BranchService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@RestController
@CrossOrigin(origins = "http://localhost:5176")
public class BranchController {
	@Autowired
	BranchService branchservice;
	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch)
	{
		return branchservice.saveBranch(branch);
	}


	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById (@RequestParam int oldBranchId,@RequestBody Branch newBranch) {

		return branchservice.updateBranchById(oldBranchId, newBranch);
	}

	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchservice.fetchBranchById(branchId);
	}

	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId) {

		return branchservice.deleteBranchById(branchId);
	}

	@GetMapping("/fetchAllBranch")
	public List<Branch> fetchAllBranch() {
		return branchservice.fetchAllBranch();
	}
	
	//Branch------>>>>Employee
	
	@PutMapping("/addingExistingEmployeeToExistingBranch")
	public Branch addingExistingEmployeeToExistingBranch(@RequestParam int branchId,@RequestParam int employeeId)
	{
		return branchservice.addingExistingEmployeeToExistingBranch(branchId,employeeId);
	}
	@PutMapping("/addingNewEmployeeToExistingBranch")
	public Branch addingNewEmployeeToExistingBranch(@RequestParam int branchId,@RequestBody Employee employee)
	{
		return branchservice.addingNewEmployeeToExistingBranch(branchId,employee);
		
	}
	
	
	//Branch------>>>>>BranchHead
	
	@PutMapping("/addingExistingBranchHeadToExistingBranch")
	public Branch addingExistingBranchHeadToExistingBranch(@RequestParam int branchHeadId,@RequestParam int branchId)
	{
		return branchservice.addingExistingBranchHeadToExistingBranch(branchHeadId, branchId);
	}
	@PutMapping("/addingNewBranchHeadToExistingBranch")
	public Branch addingNewBranchHeadToExistingBranch(@RequestParam int branchId,@RequestBody BranchHead branchHead)
	{
		return branchservice.addingNewBranchHeadToExistingBranch(branchId,branchHead);
	}
	
	
	//Branch------------>>>>>>>>Address
	
	@PutMapping("/addingExistingAddressToExistingBranch")
	public Branch addingExistingAddressToExistingBranch(@RequestParam int addressId,@RequestParam int branchId)
	{
		return branchservice.addingExistingAddressToExistingBranch(addressId, branchId);
	}
	@PutMapping("/addingNewAddressToExistingBranch")
	public Branch addingNewAddressToExistingBranch(@RequestParam int branchId,@RequestBody Address address)
	{
		return branchservice.addingNewAddressToExistingBranch(branchId,address);
	}

	
	//Branch------>>>>Patient
	
		@PutMapping("/addingExistingPatientToExistingBranch")
		public Branch addingExistingPatientToExistingBranch(@RequestParam int  branchId,@RequestParam int patientId)
		{
			return branchservice.addingExistingPatientToExistingBranch(branchId,patientId);
		}
		@PutMapping("/addingNewPatientToExistingBranch")
		public Branch addingNewPatientToExistingBranch(@RequestParam int branchId,@RequestBody Patient patient)
		{
			return branchservice.addingNewPatientToExistingBranch(branchId,patient);
			
		}

}
