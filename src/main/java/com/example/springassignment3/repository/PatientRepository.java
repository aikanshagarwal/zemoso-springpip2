package com.example.springassignment3.repository;

import com.example.springassignment3.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer>
{

}
