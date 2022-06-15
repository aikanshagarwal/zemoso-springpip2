package com.example.springassignment3;

import com.example.springassignment3.repository.TestRepository;
import com.example.springassignment3.service.TestServiceImpl;
import com.example.springassignment3.entity.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class TestService
{
    @InjectMocks
    private TestServiceImpl testService;

    @Mock
    private TestRepository testRepository;

    @BeforeEach()
    void setup() throws Exception
    {
        MockitoAnnotations.openMocks(this);
    }

    @org.junit.jupiter.api.Test
    void saveATest()
    {
        Test theTest = new Test();
        theTest.setId(1);
        theTest.setName("Cholesterol test");

        testService.saveTest(theTest);

        Mockito.when(testRepository.save(theTest)).thenReturn(theTest);

        Mockito.verify(testRepository).save(theTest);
    }

    @org.junit.jupiter.api.Test
    void findTestById()
    {
        Test theTest = new Test();
        theTest.setId(1);
        theTest.setName("Cholesterol test");

        Mockito.when(testRepository.findById(1)).thenReturn(Optional.of(theTest));

        Optional<Test> test = testService.findTestById(1);

        Assertions.assertEquals(1,test.get().getId());
        Assertions.assertEquals("Cholesterol test",test.get().getName());
    }

    @org.junit.jupiter.api.Test
    void deleteTestById()
    {
        Test theTest = new Test();
        theTest.setId(1);
        theTest.setName("Cholesterol test");

        testService.deleteTestById(1);
        Mockito.verify(testRepository).deleteById(1);
    }



}
