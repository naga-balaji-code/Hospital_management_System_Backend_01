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

import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.dto.Report;
import com.project.hospital_managemnet_system_E4.service.ReportService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@RestController
//@CrossOrigin(origins = "http://localhost:5176")
@CrossOrigin(origins = "*") 
public class ReportController 
{

	@Autowired
	ReportService reportService;

	@PostMapping("/saveReport")
	public ResponseEntity<ResponseStructure<Report>> saveReport(@RequestBody Report report) {
		return reportService.saveReport(report);
	}

	@PutMapping("/updateReportById")
	public ResponseEntity<ResponseStructure<Report>> updateReportById (@RequestParam int oldReportId,@RequestBody Report newReport) {

		return reportService.updateReportById(oldReportId, newReport);
	}

	@GetMapping("/fetchReportById")
	public ResponseEntity<ResponseStructure<Report>> fetchReportById(@RequestParam int reportId) {
		return reportService.fetchReportById(reportId);
	}

	@DeleteMapping("/deleteReportById")
	public ResponseEntity<ResponseStructure<Report>> deleteReportById(@RequestParam int reportId) {

		return reportService.deleteReportById(reportId);
	}

	@GetMapping("/fetchAllReport")
	public List<Report> fetchAllReport() {
		return reportService.fetchAllReport();
	}
	

}
