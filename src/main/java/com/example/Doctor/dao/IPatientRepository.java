package com.example.Doctor.dao;

import com.example.Doctor.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient,Integer> {

}
