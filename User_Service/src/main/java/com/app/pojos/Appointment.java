package com.app.pojos;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "appointments")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Integer appointmentId;

	@Column(name = "appointment_time")
	private String appointmentTime;

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public Appointment(Integer appointmentId, String appointmentTime) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentTime = appointmentTime;
	}

	public Appointment(Integer appointmentId, String appointmentTime, LocalDate appointmentDate, Doctor doctor,
			Patient patient) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentTime = appointmentTime;
		this.appointmentDate = appointmentDate;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@JsonProperty
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
