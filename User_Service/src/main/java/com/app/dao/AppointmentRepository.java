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
	
	Appointment findByAppointmentTimeAndAppointmentDateAndDoctor(String time,LocalDate dt,Doctor doc);
	
}
 