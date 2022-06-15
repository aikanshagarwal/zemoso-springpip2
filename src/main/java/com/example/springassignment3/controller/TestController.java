package com.example.springassignment3.controller;

import com.example.springassignment3.entity.Test;
import com.example.springassignment3.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test-management")
public class TestController
{
    @Autowired
    TestService theTestService;

    @GetMapping("/tests")
    public List<Test> getTestList()
    {
        return theTestService.findAllTests();
    }
}
