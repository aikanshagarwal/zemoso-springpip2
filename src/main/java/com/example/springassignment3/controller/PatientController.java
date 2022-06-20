package com.example.springassignment3.controller;

import com.example.springassignment3.entity.Patient;
import com.example.springassignment3.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
@RequestMapping("/patients")
public class PatientController implements WebMvcConfigurer
{
    @Autowired
    PatientService thePatientService;

    Logger logger = LoggerFactory.getLogger(PatientController.class);

    @GetMapping("/formForAdd")
    public String formForAdd(Model theModel)
    {
        Patient thePatient = new Patient();
        theModel.addAttribute("thePatient" ,thePatient);
        logger.info("...calling Patient-Form for adding a new patient...");
        return "patient-form";
    }

    @PostMapping("/save")
    public String savePatient(@Valid @ModelAttribute("thePatient") Patient thePatient , BindingResult theBindingResult , Model theModel)
    {
        if(theBindingResult.hasErrors())
        {
            logger.info("...form has errors...");
            return "patient-form";
        }

        thePatientService.savePatient(thePatient);
        logger.info("...Saving the patient based on the form filled...");

        return "adding-successful";
    }
}
