package com.app.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.pojos.*;

public class PrescriptionMedicineDTO {
	private String symptoms;
	private String precautions;
	// private Date createdOn;
	private Medicine[] listOfMedicine;
	private int doctorId;
	private int patientId;
	private String appointmentTime;
	
	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getPrecautions() {
		return precautions;
	}

	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}

	public Medicine[] getListOfMedicine() {
		return listOfMedicine;
	}

	public void setListOfMedicine(Medicine[] listOfMedicine) {
		this.listOfMedicine = listOfMedicine;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	@Override
	public String toString() {
		return "PrescriptionMedicineDTO [symptoms=" + symptoms + ", precautions=" + precautions + ", listOfMedicine="
				+ Arrays.toString(listOfMedicine) + ", doctorId=" + doctorId + ", patientId=" + patientId + "]";
	}
}
