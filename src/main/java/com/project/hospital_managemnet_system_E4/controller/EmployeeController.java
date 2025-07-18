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

import com.project.hospital_managemnet_system_E4.dto.BranchHead;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.service.EmployeeService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@RestController
//@CrossOrigin(origins = "http://localhost:5176")
@CrossOrigin(origins = "*") 
public class EmployeeController 
{

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}


	@PutMapping("/updateEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById (@RequestParam int oldEmployeeId,@RequestBody Employee newEmployee) {

		return employeeService.updateEmployeeById(oldEmployeeId, newEmployee);
	}

	@GetMapping("/fetchEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}

	@DeleteMapping("/deleteEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@RequestParam int employeeId) {

		return employeeService.deleteEmployeeById(employeeId);
	}

	@GetMapping("/fetchAllEmployee")
	public List<Employee> fetchAllEmployee() {
		return employeeService.fetchAllEmployee();
	}
}
