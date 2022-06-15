package com.example.springassignment3.service;

import com.example.springassignment3.entity.Patient;
import com.example.springassignment3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService
{

    @Autowired
    private PatientRepository thePatientRepository;

    @Override
    @Transactional
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
    @Transactional
    public void deletePatientById(int theId)
    {
        thePatientRepository.deleteById(theId);
    }
}
