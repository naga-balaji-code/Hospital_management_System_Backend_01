package com.project.hospital_managemnet_system_E4.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.BranchDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.dto.Hospital;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.dto.Patient;
import com.project.hospital_managemnet_system_E4.exception.BranchIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class BranchService {
	
	 @Autowired
	   BranchDao branchDao;
	   
	 @Autowired
	ResponseStructure<Branch> responseStructure;
		   
 public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setMessage("Suucessfully branch created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId, Branch newBranch) {
		responseStructure.setMessage("Suucessfully branch Updated in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);

		//return branchDao.updateBranchById(oldBranchId, newBranch);
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		Branch branch=branchDao.fetchBranchById(branchId);
		if(branch!=null)
		{
		responseStructure.setMessage("Suucessfully branch Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(branchDao.fetchBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new BranchIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		responseStructure.setMessage("Suucessfully branch deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.deleteBranchById(branchId));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		
	}

		public List<Branch> fetchAllBranch() {
			return branchDao.fetchAllBranch();
		}
		
		//Branch----->>>Employee
		
		public Branch addingExistingEmployeeToExistingBranch(int branchId,int employeeId)
		{
			return branchDao.addingExistingEmployeeToExistingBranch(branchId,employeeId);
		}
		
		public Branch addingNewEmployeeToExistingBranch(int branchId,Employee employee)
		{
			return branchDao.addingNewEmployeeToExistingBranch(branchId,employee);
			
		}
		
		//Branch--------->>>>BranchHead
		
		public Branch addingExistingBranchHeadToExistingBranch(int branchHeadId,int branchId)
		{
			return branchDao.addingExistingBranchHeadToExistingBranch(branchHeadId, branchId);
		}
		
		public Branch addingNewBranchHeadToExistingBranch(int branchId,BranchHead branchHead)
		{
			return branchDao.addingNewBranchHeadToExistingBranch(branchId,branchHead);
		}
		
		
		//Branch--------->>>>Address
		
		public Branch addingExistingAddressToExistingBranch(int addressId,int branchId)
	     {
			return branchDao.addingExistingAddressToExistingBranch(addressId, branchId);
		}
		
		public Branch addingNewAddressToExistingBranch(int branchId,Address address)
		{
			return branchDao.addingNewAddressToExistingBranch(branchId,address);
		}
		
		
		
		//branch------->>>Patient
		
		public Branch addingExistingPatientToExistingBranch(int branchId,int patientId)
		{
			return branchDao.addingExistingPatientToExistingBranch(branchId,patientId);
		}
		
		public Branch addingNewPatientToExistingBranch(int branchId,Patient patient)
		{
			return branchDao.addingNewPatientToExistingBranch(branchId,patient);
			
		}
		

}
