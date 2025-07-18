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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.service.AddressService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;


@RestController
//@CrossOrigin(origins = "http://localhost:5176")
@CrossOrigin(origins = "*") 

public class AddressController
{

	@Autowired
	AddressService addressService;
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>>saveAddress(@RequestBody Address address)
	{
		return addressService.saveAddress(address);
	}


	@PutMapping("/updateAddressById")
	public ResponseEntity<ResponseStructure<Address>> updateAddressById (@RequestParam int oldAddressId,@RequestBody Address newAddress) {

		return addressService.updateAddressById(oldAddressId, newAddress);
	}

	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}

	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {

		return addressService.deleteAddressById(addressId);
	}

	@GetMapping("/fetchAllAddress")
	public List<Address> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}

}
