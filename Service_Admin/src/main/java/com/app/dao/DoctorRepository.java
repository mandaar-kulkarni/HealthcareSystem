package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
