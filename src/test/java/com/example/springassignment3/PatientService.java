package com.example.springassignment3;

import com.example.springassignment3.entity.Patient;
import com.example.springassignment3.repository.PatientRepository;
import com.example.springassignment3.service.PatientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class PatientService
{
    @InjectMocks
    private PatientServiceImpl patientService;

    @Mock
    private PatientRepository patientRepository;

    @BeforeEach
    void setup() throws Exception
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSavePatient()
    {
        Patient thePatient = new Patient();
        thePatient.setId(1);
        thePatient.setName("Ravi");
        thePatient.setBookingFor("Myself");
        thePatient.setGender("Male");

        patientService.savePatient(thePatient);

        Mockito.when(patientRepository.save(thePatient)).thenReturn(thePatient);

        Mockito.verify(patientRepository).save(thePatient);
    }

    @Test
    void testFindPatientById()
    {
        Patient thePatient = new Patient();
        thePatient.setId(1);
        thePatient.setName("Ravi");
        thePatient.setBookingFor("Myself");
        thePatient.setGender("Male");

        Mockito.when(patientRepository.findById(1)).thenReturn(Optional.of(thePatient));

        Optional<Patient> patient = patientService.findPatientById(1);

        Assertions.assertEquals(1,patient.get().getId());
        Assertions.assertEquals("Ravi",patient.get().getName());
        Assertions.assertEquals("Myself",patient.get().getBookingFor());
        Assertions.assertEquals("Male",patient.get().getGender());
    }

    @Test
    void testDeletePatientById()
    {
        Patient thePatient = new Patient();
        thePatient.setId(1);
        thePatient.setName("Ravi");
        thePatient.setBookingFor("Myself");
        thePatient.setGender("Male");

        patientService.deletePatientById(1);
        Mockito.verify(patientRepository).deleteById(1);
    }

}
