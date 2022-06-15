package com.example.springassignment3.service;

import com.example.springassignment3.entity.Test;

import java.util.List;
import java.util.Optional;

public interface TestService
{
    public void saveTest(Test theTest);

    public List<Test> findAllTests();

    public Optional<Test> findTestById(int theId);

    public void deleteTestById(int theId);
}
