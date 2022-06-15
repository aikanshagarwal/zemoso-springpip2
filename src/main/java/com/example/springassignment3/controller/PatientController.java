package com.example.springassignment3.controller;

import com.example.springassignment3.entity.Patient;
import com.example.springassignment3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient-management")
public class PatientController
{
    @Autowired
    PatientService thePatientService;

    @GetMapping("/patients")
    public List<Patient> getPatientList()
    {
        return thePatientService.findAllPatients();
    }

    @GetMapping("/patients/{patientId}")
    public Optional<Patient> getPatientById(@PathVariable int patientId)
    {
        return thePatientService.findPatientById(patientId);
    }

    @PostMapping("/patients")
    public Patient savePatient(@RequestBody Patient thePatient)
    {
        thePatient.setId(0);
        thePatientService.savePatient(thePatient);
        return thePatient;
    }

    @PutMapping("/patients")
    public Patient updatePatient(@RequestBody Patient thePatient)
    {
        thePatientService.savePatient(thePatient);
        return thePatient;
    }

    @DeleteMapping("/patients/{patientId}")
    public void deletePatientById(@PathVariable int patientId)
    {
        thePatientService.deletePatientById(patientId);
    }
}
