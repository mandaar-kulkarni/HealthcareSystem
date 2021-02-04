package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Prescription;
import java.util.*;
import com.app.pojos.Patient;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

	@Query("select new com.app.pojos.Prescription(p.prescriptionId,p.symptoms,p.precautions) from Prescription p where p.patient=?1")
	List<Prescription> findAllByPatient(Patient patient);

}
