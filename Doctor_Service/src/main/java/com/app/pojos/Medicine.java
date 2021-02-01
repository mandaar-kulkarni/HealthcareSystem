package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "medicines")
@JsonInclude(Include.NON_NULL)
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_id")
	private Integer medicineId;
	@Column(name = "medicine_name", length = 50)
	private String medicineName;
	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "prescription_id")
	private Prescription prescriptionId;

	public Medicine() {
		super();
	}

	public Medicine(Integer medicineId, String medicineName, int quantity,Prescription prescriptionId) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.prescriptionId=prescriptionId;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Prescription getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Prescription prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", quantity=" + quantity + "]";
	}

}