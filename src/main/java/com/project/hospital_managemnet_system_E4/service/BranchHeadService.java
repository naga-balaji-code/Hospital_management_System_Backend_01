package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.BranchHeadDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.exception.BranchHeadIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class BranchHeadService
{
	 @Autowired
	   BranchHeadDao branchHeadDao;
	   
	 @Autowired
	ResponseStructure<BranchHead> responseStructure;
		   
 public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(BranchHead branchHead) {
		responseStructure.setMessage("Suucessfully branchHead created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchHeadDao.saveBranchHead(branchHead));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHeadById(int oldBranchHeadId, BranchHead newBranchHead) {
		responseStructure.setMessage("Suucessfully branchHead Updated in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchHeadDao.updateBranchHeadById(oldBranchHeadId, newBranchHead));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.CREATED);

		//return branchHeadDao.updateBranchHeadById(oldBranchHeadId, newBranchHead);
	}

	public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(int branchHeadId) {
		BranchHead branchHead=branchHeadDao.fetchBranchHeadById(branchHeadId);
		if(branchHead!=null)
		{
		responseStructure.setMessage("Suucessfully branchHead Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(branchHeadDao.fetchBranchHeadById(branchHeadId));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new BranchHeadIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(int branchHeadId) {
		responseStructure.setMessage("Suucessfully branchHead deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchHeadDao.deleteBranchHeadById(branchHeadId));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure,HttpStatus.OK);
		
	}
		public List<BranchHead> fetchAllBranchHead() {
			return branchHeadDao.fetchAllBranchHead();
		}

}

