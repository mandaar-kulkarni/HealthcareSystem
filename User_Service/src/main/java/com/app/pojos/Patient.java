package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private Integer patientId;

	@Column(length = 35, name = "first_name")
	private String firstName;

	@Column(length = 35, name = "last_name")
	private String lastName;

	@Column(length = 50, name = "emailid", unique = true)
	private String emailId;

	@Column(length = 10, name = "phone_number", unique = true)
	private String phoneNumber;

	@Column(length = 50)
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@Column(name = "age")
	private int age;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(Integer patientId, String firstName, String lastName, String emailId, String phoneNumber,
			String address, Gender gender, int age) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.gender = gender;
		this.age = age;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", phoneNumber=" + phoneNumber + ", address=" + address + ", gender=" + gender + ", age="
				+ age + "]";
	}
}