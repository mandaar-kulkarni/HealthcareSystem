package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Medicine;
import com.app.pojos.Prescription;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer> {
	
	
	
	@Query("select new com.app.pojos.Medicine(m.medicineId,m.medicineName,m.quantity,m.prescriptionId) from Medicine m where m.prescriptionId=?1")
	List<Medicine> findAllByPrescriptionId(Prescription p);

}
