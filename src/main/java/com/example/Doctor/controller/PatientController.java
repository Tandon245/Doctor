package com.example.Doctor.controller;

import com.example.Doctor.dao.IDoctorRepository;
import com.example.Doctor.model.Doctor;
import com.example.Doctor.model.Patient;
import com.example.Doctor.service.PatientService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    IDoctorRepository doctorRepository;
    @Autowired
    PatientService patientService;


    @PostMapping(value = "/patient")
    public  String savePatient(@RequestBody  String patientRequest){
        JSONObject json=new JSONObject(patientRequest);
        Patient patient =setPatient(json);
patientService.savePatient(patient);
return "Patient saved";
    }
@GetMapping("/patient")
    public ResponseEntity getPatients(@Nullable @RequestParam String doctorId, @Nullable @RequestParam String patientId){
    JSONArray patientDetails=patientService.getpatients();
    return  new ResponseEntity<>(patientDetails.toString(), HttpStatus.OK);
    }

    private Patient setPatient(JSONObject json) {
Patient patient=new Patient();
        patient.setPatientName(json.getString("patientName"));
patient.setPatientId(json.getInt("patientId"));

patient.setAge(json.getInt("age"));
patient.setGender(json.getString("gender"));
patient.setPhoneNumber(json.getString("phoneNumber"));
patient.setDiseaseType(json.getString("diseaseType"));
        Timestamp currTime=new Timestamp(System.currentTimeMillis());
        patient.setAdmitDate(currTime);
        String doctorId=json.getString("doctorId");
       Doctor doctor= doctorRepository.findById(Integer.valueOf(doctorId)).get();
       patient.setDoctor(doctor);
       return  patient;
    }


}
