package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import com.app.pojos.*;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
	
	List<Appointment> findAllByPatient(Patient patient);
	
	//@Query("Select a from Appointment a ")
	Appointment findByAppointmentTimeAndAppointmentDateAndDoctor(String time,LocalDate dt,Doctor doc);
	
//	@Query("Select new com.app.pojos.Doctor(d.doctorId,d.firstName,d.lastName,d.emailId,d.phoneNumber) from Doctor d where d.specialization=?1")
//	List<Doctor> findAllBySpecialization(Department spec);
}
 