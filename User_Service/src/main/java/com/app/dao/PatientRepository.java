package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findByEmailId(String emailid);
}
