package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Prescription;
import java.util.*;
import com.app.pojos.Patient;
public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {
	
	List<Prescription> findAllByPatient(Patient patient);

}
