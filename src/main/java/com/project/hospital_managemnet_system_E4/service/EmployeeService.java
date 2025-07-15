package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.EmployeeDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Employee;
import com.project.hospital_managemnet_system_E4.exception.EmployeeIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@Service
public class EmployeeService
{
	 @Autowired
	   EmployeeDao employeeDao;
	   
	 @Autowired
	ResponseStructure<Employee> responseStructure;
		   
 public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		responseStructure.setMessage("Suucessfully Employee created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(int oldEmployeeId, Employee newEmployee) {
		responseStructure.setMessage("Suucessfully Employee Updated in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.updateEmployeeById(oldEmployeeId, newEmployee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.CREATED);

		//return EmployeeDao.updateEmployeeById(oldEmployeeId, newEmployee);
	}

	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(int EmployeeId) {
		Employee employee=employeeDao.fetchEmployeeById(EmployeeId);
		if(employee!=null)
		{
		responseStructure.setMessage("Suucessfully Employee Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(employeeDao.fetchEmployeeById(EmployeeId));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new EmployeeIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int employeeId) {
		responseStructure.setMessage("Suucessfully Employee deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure,HttpStatus.OK);
		
	}

		public List<Employee> fetchAllEmployee() {
			return employeeDao.fetchAllEmployee();
		}


}
