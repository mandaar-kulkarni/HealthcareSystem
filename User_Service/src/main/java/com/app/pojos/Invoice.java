package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id")
	private Integer invoiceId;
	@Column(name = "doctor_fee")
	private int doctorFee;
	@Column(name = "total_amount", nullable = false)
	private int totalAmount;
	@Column(name = "created_on")
	private LocalDate createdOn;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Invoice() {
		// TODO Auto-generated constructor stub
	}

	public Invoice(Integer invoiceId, int doctorFee, int totalAmount, LocalDate createdOn) {
		super();
		this.invoiceId = invoiceId;
		this.doctorFee = doctorFee;
		this.totalAmount = totalAmount;
		this.createdOn = createdOn;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getDoctorFee() {
		return doctorFee;
	}

	public void setDoctorFee(int doctorFee) {
		this.doctorFee = doctorFee;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
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
		return "Invoice [invoiceId=" + invoiceId + ", doctorFee=" + doctorFee + ", totalAmount=" + totalAmount
				+ ", createdOn=" + createdOn + "]";
	}

}