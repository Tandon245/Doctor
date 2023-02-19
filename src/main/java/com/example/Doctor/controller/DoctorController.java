package com.example.Doctor.controller;

import com.example.Doctor.model.Doctor;
import com.example.Doctor.service.DoctorService;
import jakarta.annotation.Nullable;
import jakarta.websocket.server.PathParam;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController

public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping(value = "/doctor")
    public ResponseEntity<String> saveDoctor(@RequestBody String requestdoctor){

        JSONObject json=new JSONObject(requestdoctor);
        List<String > validationList=validateDoctor(json);
      if(validateDoctor(json).isEmpty()){
          Doctor doctor=setDoctor(json);
          doctorService.saveDoctor(doctor);
          return new ResponseEntity<>("Doctor save",HttpStatus.CREATED);
      }else{
          String[] ans= Arrays.copyOf(
                  validationList.toArray(),validationList.size(),String[].class);
          return  new ResponseEntity<>("please pass mandatory these parameters-  "+Arrays.toString(ans),HttpStatus.BAD_REQUEST);
      }




    }

    private List<String> validateDoctor(JSONObject json) {

        List<String> errorList=new ArrayList<>();
if(!json.has("doctorId")){
    errorList.add("doctorId");
}
        if(!json.has("doctorName")){
            errorList.add("doctorName");
        }

        if(!json.has("experience")){
            errorList.add("experience");
        }
        return  errorList;
    }

    public Doctor setDoctor(JSONObject json){
        Doctor doctor=new Doctor();
        String doctorId= json.getString("doctorId");
        doctor.setDoctorId(Integer.valueOf(doctorId));
        String  doctorName=json.getString("doctorName");
        doctor.setDoctorName(doctorName);
        String specializedIn=json.getString("specializedIn");
        doctor.setSpecializedIn(specializedIn);
        if(json.has("experience")){
            String exp=json.getString("experience");
            doctor.setExperience(exp);
        }
        return doctor;
    }
    @GetMapping(value = "/doctor")
    public List<Doctor> getDoctor (@Nullable @RequestParam String doctorId){
        return  doctorService.getDoctor(doctorId);

    }

}
