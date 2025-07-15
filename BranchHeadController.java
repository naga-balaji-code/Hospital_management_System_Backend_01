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

import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.service.BranchHeadService;
@RestController
public class BranchHeadController {
	@Autowired
	BranchHeadService branchHeadService;
	@PostMapping("/saveBranchHead")
	public BranchHead saveBranchHead(@RequestBody BranchHead branchHead)
	{
		return branchHeadService.saveBranchHead(branchHead);
	}


	@PutMapping("/updateBranchHeadById")
	public BranchHead updateBranchHeadById (@RequestParam int oldBranchHeadId,@RequestBody BranchHead newBranchHead) {

		return branchHeadService.updateBranchHeadById(oldBranchHeadId, newBranchHead);
	}

	@GetMapping("/fetchBranchHeadById")
	public BranchHead fetchBranchHeadById(@RequestParam int branchHeadId) {
		return branchHeadService.fetchBranchHeadById(branchHeadId);
	}

	@DeleteMapping("/deleteBranchHeadById")
	public BranchHead deleteBranchHeadById(@RequestParam int branchHeadId) {

		return branchHeadService.deleteBranchHeadById(branchHeadId);
	}

	@GetMapping("/fetchAllBranchHead")
	public List<BranchHead> fetchAllBranchHead() {
		return branchHeadService.fetchAllBranchHead();
	}


}
