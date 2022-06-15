package com.example.springassignment3.service;

import com.example.springassignment3.entity.Lab;

import java.util.List;
import java.util.Optional;

public interface LabService
{
    public void saveLab(Lab theLab);

    public List<Lab> findAllLabs();

    public Optional<Lab> findLabById(int theId);

    public void deleteLabById(int theId);
}
