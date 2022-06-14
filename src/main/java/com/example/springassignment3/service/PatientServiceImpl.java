package com.example.springassignment3.service;

import com.example.springassignment3.entity.Patient;
import com.example.springassignment3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PatientServiceImpl implements PatientService
{

    @Autowired
    private PatientRepository thePatientRepository;

    @Override
    public void savePatient(Patient thePatient)
    {
        thePatientRepository.save(thePatient);
    }

    @Override
    public List<Patient> findAllPatients()
    {
        return thePatientRepository.findAll();
    }

    @Override
    public Optional<Patient> findPatientById(int theId)
    {
        return thePatientRepository.findById(theId);
    }

    @Override
    public void deletePatientById(int theId)
    {
        thePatientRepository.deleteById(theId);
    }
}
