package com.project.hospital_managemnet_system_E4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_managemnet_system_E4.dao.MedicineDao;
import com.project.hospital_managemnet_system_E4.dto.Address;
import com.project.hospital_managemnet_system_E4.dto.Medicine;
import com.project.hospital_managemnet_system_E4.exception.MedicineIdNotFound;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@Service
public class MedicineService 
{

	@Autowired
	   MedicineDao medicineDao;
	   
	 @Autowired
	ResponseStructure<Medicine> responseStructure;
		   
 public ResponseEntity<ResponseStructure<Medicine>> saveMedicine(Medicine medicine) {
		responseStructure.setMessage("Suucessfully medicine created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(medicineDao.saveMedicine(medicine));
		return new ResponseEntity<ResponseStructure<Medicine>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Medicine>> updateMedicineById(int oldMedicineId, Medicine newMedicine) {
		responseStructure.setMessage("Suucessfully medicine Updated in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(medicineDao.updateMedicineById(oldMedicineId, newMedicine));
		return new ResponseEntity<ResponseStructure<Medicine>>(responseStructure,HttpStatus.CREATED);

		//return medicineDao.updateMedicineById(oldMedicineId, newMedicine);
	}

	public ResponseEntity<ResponseStructure<Medicine>> fetchMedicineById(int medicineId) {
		Medicine medicine=medicineDao.fetchMedicineById(medicineId);
		if(medicine!=null)
		{
		responseStructure.setMessage("Suucessfully medicine Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(medicineDao.fetchMedicineById(medicineId));
		return new ResponseEntity<ResponseStructure<Medicine>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new MedicineIdNotFound();
		}
		
	}

	public ResponseEntity<ResponseStructure<Medicine>> deleteMedicineById(int medicineId) {
		responseStructure.setMessage("Suucessfully medicine deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(medicineDao.deleteMedicineById(medicineId));
		return new ResponseEntity<ResponseStructure<Medicine>>(responseStructure,HttpStatus.OK);
		
	}
		public List<Medicine> fetchAllMedicine() {
			return medicineDao.fetchAllMedicine();
		}
}
