package com.app.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.app.pojos.*;

public class Prescription {

	private String symptoms;
	private String precautions;
	private LocalDate createdOn;
	private Medicine[] listOfMedicine;
	private int doctorId;
	private int patientId;

	public Prescription() {

	}

	public Prescription(String symptoms, String precautions, LocalDate createdOn, Medicine[] medicine, int doctorId,
			int patientId) {
		super();
		this.symptoms = symptoms;
		this.precautions = precautions;
		this.createdOn = createdOn;
		this.listOfMedicine = medicine;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}

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

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
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

	@Override
	public String toString() {
		return "Prescription [symptoms=" + symptoms + ", precautions=" + precautions + ", createdOn=" + createdOn
				+ ", listOfMedicine=" + Arrays.toString(listOfMedicine) + ", doctorId=" + doctorId + ", patientId="
				+ patientId + "]";
	}

}
