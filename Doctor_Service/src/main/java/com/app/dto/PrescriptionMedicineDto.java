package com.app.dto;

import java.util.List;

import com.app.pojos.Medicine;
import com.app.pojos.Prescription;

public class PrescriptionMedicineDto {

	private Prescription prescription;
	private List<Medicine> medicine;
	
	
	public PrescriptionMedicineDto() {
	
	}


	public PrescriptionMedicineDto(Prescription prescription, List<Medicine> medicine) {
		super();
		this.prescription = prescription;
		this.medicine = medicine;
	}


	public Prescription getPrescription() {
		return prescription;
	}


	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}


	public List<Medicine> getMedicine() {
		return medicine;
	}


	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}
		
}
