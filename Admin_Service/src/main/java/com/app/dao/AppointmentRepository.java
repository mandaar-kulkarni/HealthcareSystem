package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.*;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	List<Appointment> findAllByDoctor(Doctor d);
}
