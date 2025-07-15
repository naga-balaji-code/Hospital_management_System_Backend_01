package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.AddressDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Owner;
import com.project.hospital_managemnet_system_E4.exception.AddressIdNotFound;
import com.project.hospital_managemnet_system_E4.exception.OwnerIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;
@Service
public class AddressService 
{
	 @Autowired 
	   AddressDao addressDao;
	 @Autowired
	ResponseStructure<Address> responseStructure;
	   
 public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setMessage("Suucessfully address created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddressById(int oldAddressId, Address newAddress) {
		responseStructure.setMessage("Suucessfully address Updated in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);

		//return addressDao.updateAddressById(oldAddressId, newAddress);
	}

	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null)
		{
		responseStructure.setMessage("Suucessfully address Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(addressDao.fetchAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new AddressIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		responseStructure.setMessage("Suucessfully address deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		
	}

		public List<Address> fetchAllAddress() {
			return addressDao.fetchAllAddress();
		}
	
	
}
