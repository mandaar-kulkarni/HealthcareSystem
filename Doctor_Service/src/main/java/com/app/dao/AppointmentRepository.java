package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.app.pojos.Appointment;
import com.app.pojos.Doctor;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
//	
//	List<Appointment> findAllByPatient(Patient patient);
	
	@Query("select new com.app.pojos.Appointment(a.appointmentId,a.appointmentTime,a.patient) from Appointment a where a.doctor=?1")
	List<Appointment> findAllByDoctor(Doctor doctor);

}
 