package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "appointments")
@JsonInclude(Include.NON_NULL)
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Integer appointmentId;
	@Column(name = "appointment_time")
	private LocalDate appointmentTime;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	
	public Appointment(Integer appointmentId, LocalDate appointmentTime, Patient patient) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentTime = appointmentTime;
		this.patient = patient;
	}


	public Appointment(Integer appointmentId, LocalDate appointmentTime) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentTime = appointmentTime;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalDate appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentTime=" + appointmentTime + "]";
	}

}
