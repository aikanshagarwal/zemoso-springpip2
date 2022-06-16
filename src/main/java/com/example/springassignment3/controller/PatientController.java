package com.example.springassignment3.controller;

import com.example.springassignment3.entity.Patient;
import com.example.springassignment3.exception.PatientNotFoundException;
import com.example.springassignment3.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(PatientController.class);

    @GetMapping("/patients")
    public List<Patient> getPatientList()
    {
        logger.info("...Getting the list of all patients...");
        return thePatientService.findAllPatients();
    }

    @GetMapping("/patients/{patientId}")
    public Optional<Patient> getPatientById(@PathVariable int patientId)
    {
        logger.info("...Getting patient based on the given Id...");
        Optional<Patient> thePatient = thePatientService.findPatientById(patientId);

        if(!thePatient.isPresent())
        {
            throw new PatientNotFoundException("Patient with id " + patientId + " could not be found");
        }

        return thePatient;
    }

    @PostMapping("/patients")
    public Patient savePatient(@RequestBody Patient thePatient)
    {
        thePatient.setId(0);
        thePatientService.savePatient(thePatient);
        logger.info("...Saving a patient...");
        return thePatient;
    }

    @PutMapping("/patients")
    public Patient updatePatient(@RequestBody Patient thePatient)
    {
        thePatientService.savePatient(thePatient);
        logger.info("...Updating a patient...");
        return thePatient;
    }

    @DeleteMapping("/patients/{patientId}")
    public String deletePatientById(@PathVariable int patientId)
    {
        logger.info("...Deleting patient given an Id...");
        Optional<Patient> thePatient = thePatientService.findPatientById(patientId);

        if(!thePatient.isPresent())
        {
            throw new PatientNotFoundException("Patient with id " + patientId + " could not be found");
        }

        thePatientService.deletePatientById(patientId);
        return "The patient with the given id was deleted.";
    }
}
