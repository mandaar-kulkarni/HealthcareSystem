package com.app.dto;

import java.time.LocalDate;

public class AppointmentDTO {

	private int patientId;
	private int doctorId;
	private LocalDate appointmentDate;
	private String appointmentTime;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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

	@Override
	public String toString() {
		return "AppointmentDTO [patientId=" + patientId + ", doctorId=" + doctorId + ", appointmentDate="
				+ appointmentDate + ", appointmentTime=" + appointmentTime + "]";
	}

}
