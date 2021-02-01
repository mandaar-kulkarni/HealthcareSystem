	package com.app.pojos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "doctors")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private Integer doctorId;

	@Column(length = 15, name = "first_name")
	private String firstName;

	@Column(length = 15, name = "last_name")
	private String lastName;

	@Column(length = 50, name = "email_id", unique = true)
	private String emailId;

	@Column(name = "dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@Column(length = 10, name = "phone_number", unique = true)
	private String phoneNumber;

	@Column(length = 50)
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@Lob
	@Column(name = "degree_certificate")
	private byte[] degreeCertificate;

	@Lob
	@Column(name = "license")
	private byte[] license;

	@Enumerated(EnumType.STRING)
	@Column(length = 25)
	private Department specialization;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(Integer doctorId, String firstName, String lastName, String emailId, Date dateOfBirth,
			String phoneNumber, String address, Gender gender, byte[] degreeCertificate, byte[] license,
			Department specialization) {
		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.gender = gender;
		this.degreeCertificate = degreeCertificate;
		this.license = license;
		this.specialization = specialization;

	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public byte[] getDegreeCertificate() {
		return degreeCertificate;
	}

	public void setDegreeCertificate(byte[] degreeCertificate) {
		this.degreeCertificate = degreeCertificate;
	}

	public byte[] getLicense() {
		return license;
	}

	public void setLicense(byte[] license) {
		this.license = license;
	}

	public Department getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Department specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", gender=" + gender + ", specialization=" + specialization + "]";
	}

}
