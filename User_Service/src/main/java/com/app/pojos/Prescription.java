package com.app.pojos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "prescriptions")
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prescription_id")
	private Integer prescriptionId;

	@Column(name = "symptoms", length = 80)
	private String symptoms;

	@Column(name = "precautions", length = 80)
	private String precautions;

	@Column(name = "created_on")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdOn;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Prescription() {
		// TODO Auto-generated constructor stub
	}

	public Prescription(Integer prescriptionId, String symptoms, String precautions, Date createdOn, Doctor doctor,
			Patient patient) {
		super();
		this.prescriptionId = prescriptionId;
		this.symptoms = symptoms;
		this.precautions = precautions;
		this.createdOn = createdOn;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Integer getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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
		return "Prescription [prescriptionId=" + prescriptionId + ", symptoms=" + symptoms + ", precautions="
				+ precautions + ", createdOn=" + createdOn + "]";
	}

}