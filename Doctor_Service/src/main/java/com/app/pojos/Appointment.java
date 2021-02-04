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

	@Column(name = "appointment_date")
	private LocalDate appointmentDate;

	@Column(name = "appointment_time", length = 20)
	private String appointmentTime;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "status")
	private int status = 1;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public Appointment(Integer appointmentId, LocalDate appointmentDate, Patient patient,String appointmentTime) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.patient = patient;
		this.appointmentTime=appointmentTime;
	}

	public Appointment(Integer appointmentId, LocalDate appointmentDate) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentTime=" + appointmentTime + "]";
	}

}
