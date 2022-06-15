package com.example.springassignment3.controller;

import com.example.springassignment3.entity.Test;
import com.example.springassignment3.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/tests/{testId}")
    public Optional<Test> getTestById(@PathVariable int theId)
    {
        return theTestService.findTestById(theId);
    }

    @PostMapping("/tests")
    public Test saveTest(@RequestBody Test theTest)
    {
        theTest.setId(0);
        theTestService.saveTest(theTest);
        return theTest;
    }

    @PutMapping("/tests")
    public Test updateTest(@RequestBody Test theTest)
    {
        theTestService.saveTest(theTest);
        return theTest;
    }

    @DeleteMapping("/tests/{testId}")
    public void deleteTestById(@PathVariable int theId)
    {
        theTestService.deleteTestById(theId);
    }
}
