package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
import com.app.pojos.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	Doctor findByEmailId(String emailid);

	@Query("Select new com.app.pojos.Doctor(d.doctorId,d.firstName,d.lastName,d.emailId,d.phoneNumber) from Doctor d where d.specialization=?1 and d.status=?2")
	List<Doctor> findAllBySpecializationAndStatus(Department spec,int status);
}
