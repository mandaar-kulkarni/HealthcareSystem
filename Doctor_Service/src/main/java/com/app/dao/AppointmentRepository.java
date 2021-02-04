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
	
	@Query("select new com.app.pojos.Appointment(a.appointmentId,a.appointmentDate,a.patient,a.appointmentTime) from Appointment a where a.status=?3 and a.doctor=?1 and a.appointmentDate=?2")
	List<Appointment> findAllByDoctor(Doctor doctor,LocalDate dt,int status);

//	@Query("update Appointment a set a.status=0 where a.patient=?1 and a.appointmentDate=?2 and a.doctor=?3")
	Appointment findByPatientAndAppointmentDateAndDoctorAndAppointmentTime(Patient patient,LocalDate dt,Doctor doctor,String appointmentTime);
	
}
 