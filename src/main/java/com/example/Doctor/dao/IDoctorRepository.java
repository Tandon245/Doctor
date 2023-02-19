package com.example.Doctor.dao;

import com.example.Doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IDoctorRepository extends JpaRepository<Doctor,Integer> {
}
