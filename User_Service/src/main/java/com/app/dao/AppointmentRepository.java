package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.app.pojos.Appointment;
import com.app.pojos.Patient;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
	
	List<Appointment> findAllByPatient(Patient patient);
}
 