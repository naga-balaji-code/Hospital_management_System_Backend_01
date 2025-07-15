package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Branch;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.exception.EmployeeIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.EmployeeRepo;
@Repository
public class EmployeeDao 
{
	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	public Employee updateEmployeeById(int oldEmployeeId,Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		//	return BranchRepo.save(newBranch);
		return saveEmployee(newEmployee);
	}
	
	public Employee fetchEmployeeById(int employeeId) {
		Optional<Employee> employee=employeeRepo.findById(employeeId);
		  if(employee.isEmpty()) {
			  return null;
		  }
		  else {
			  return employee.get();
		  }
	}
	
	public Employee deleteEmployeeById(int employeeId) {
	//	Branch Branch=BranchRepo.findById(BranchId).get();
		Employee employee=fetchEmployeeById(employeeId);
		employeeRepo.delete(employee);
		return employee;
	}
	
	public List<Employee> fetchAllEmployee(){
		return employeeRepo.findAll();
	}
}
