   package com.project.hospital_managemnet_system_E4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.exception.AddressIdNotFound;
import com.project.hospital_managemnet_system_E4.repo.AddressRepo;

@Repository
public class AddressDao 
{
	@Autowired
	AddressRepo addressrepo;
	
	public Address saveAddress(Address address)
	{
		return addressrepo.save(address);
	}
	public Address updateAddressById(int oldAddressId,Address newAddress) {
		newAddress.setAddressId(oldAddressId);
		//	return Addressrepo.save(newAddress);
		return saveAddress(newAddress);
	}
	
	public Address fetchAddressById(int addressId) {
		Optional<Address> address=addressrepo.findById(addressId);
	  if(address.isEmpty()) {
		  return null;
	  }
	  else {
		  return address.get();
	  }
		
	}
	
	public Address deleteAddressById(int addressId) {
	//	Address Address=Addressrepo.findById(AddressId).get();
		Address address=fetchAddressById(addressId);
		addressrepo.delete(address);
		return address;
	}
	
	public List<Address> fetchAllAddress(){
		return addressrepo.findAll();
	}
}
