package com.example.springassignment3.service;

import com.example.springassignment3.entity.Lab;
import com.example.springassignment3.repository.LabRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LabServiceImpl implements LabService
{

    @Autowired
    private LabRepository theLabRepository;

    @Override
    public void saveLab(Lab theLab)
    {
        theLabRepository.save(theLab);
    }

    @Override
    public List<Lab> findAllLabs()
    {
        return theLabRepository.findAll();
    }

    @Override
    public Optional<Lab> findLabById(int theId) {
        return theLabRepository.findById(theId);
    }

    @Override
    public void deleteLabById(int theId)
    {
        theLabRepository.deleteById(theId);
    }
}
