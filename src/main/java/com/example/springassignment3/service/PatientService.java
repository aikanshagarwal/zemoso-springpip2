package com.example.springassignment3.service;

import com.example.springassignment3.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService
{
    public void savePatient(Patient thePatient);

    public List<Patient> findAllPatients();

    public Optional<Patient> findPatientById(int theId);

    public void deletePatientById(int theId);

}
