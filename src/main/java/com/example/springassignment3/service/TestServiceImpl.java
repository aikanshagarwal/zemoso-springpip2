package com.example.springassignment3.service;

import com.example.springassignment3.entity.Test;
import com.example.springassignment3.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TestServiceImpl implements TestService
{
    @Autowired
    private TestRepository theTestRepository;

    @Override
    public void saveTest(Test theTest)
    {
        theTestRepository.save(theTest);
    }

    @Override
    public List<Test> findAllTests()
    {
        return theTestRepository.findAll();
    }

    @Override
    public Optional<Test> findTestById(int theId)
    {
        return theTestRepository.findById(theId);
    }

    @Override
    public void deleteTestById(int theId)
    {
        theTestRepository.deleteById(theId);
    }
}
