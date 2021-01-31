package com.app.dao;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import com.app.pojos.*;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
//	
//	List<Appointment> findAllByPatient(Patient patient);
	
	@Query("select new com.app.pojos.Appointment(a.appointmentId,a.appointmentTime,a.patient) from Appointment a where a.doctor=?1 and a.appointmentTime=?2")
	List<Appointment> findAllByDoctor(Doctor doctor,LocalDate dt);

}
 