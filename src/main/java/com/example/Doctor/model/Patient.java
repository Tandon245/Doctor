package com.example.Doctor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_patient")
public class Patient {
    @Id
    @Column(name = "patient_id")
private Integer patientId;
    @Column(name = "patient_name")
private  String patientName;
    @Column(name = "age")
private  Integer age;
    @Column(name = "phone_number")
private String phoneNumber;
    @Column(name = "Disease_type")
private  String diseaseType;
    @Column(name = "gender")
private  String gender;

@Column(name = "admit_date")
    private Timestamp admitDate;

@JoinColumn(name = "doctorId")
@ManyToOne(fetch = FetchType.LAZY)
private  Doctor doctor;

}
