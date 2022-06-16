package com.example.springassignment3.controller;

import com.example.springassignment3.entity.Test;
import com.example.springassignment3.exception.TestNotFoundException;
import com.example.springassignment3.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/tests")
    public List<Test> getTestList()
    {
        logger.info("...Getting the list of all the Tests...");
        return theTestService.findAllTests();
    }

    @GetMapping("/tests/{testId}")
    public Optional<Test> getTestById(@PathVariable int testId)
    {
        logger.info("...Getting a test based on a given Id...");
        Optional<Test> theTest = theTestService.findTestById(testId);

        if(!theTest.isPresent())
        {
            throw new TestNotFoundException("Test with id " + testId + " could not be found.");
        }

        return theTest;
    }

    @PostMapping("/tests")
    public Test saveTest(@RequestBody Test theTest)
    {
        theTest.setId(0);
        theTestService.saveTest(theTest);
        logger.info("...Saving a test...");
        return theTest;
    }

    @PutMapping("/tests")
    public Test updateTest(@RequestBody Test theTest)
    {
        theTestService.saveTest(theTest);
        logger.info("...Updating a test...");
        return theTest;
    }

    @DeleteMapping("/tests/{testId}")
    public String deleteTestById(@PathVariable int testId)
    {
        logger.info("...Deleting a test given an Id...");

        Optional<Test> theTest = theTestService.findTestById(testId);

        if(!theTest.isPresent())
        {
            throw new TestNotFoundException("Test with id " + testId + " could not be found.");
        }

        theTestService.deleteTestById(testId);

        return "The test with the given id was deleted.";
    }
}
