package com.example.springassignment3.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="patient")
@Getter
@Setter
@NoArgsConstructor
public class Patient implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Please enter your Name")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Please enter your Date of Birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd" , timezone = "IST")
    @Column(name = "dob")
    private String dob;

    @NotEmpty(message = "Please select your Gender")
    @Column(name = "gender")
    private String gender;

    @NotEmpty(message = "Please select the person for whom you are booking the test")
    @Column(name = "booking_for")
    private String bookingFor;

    @ManyToOne()
    @JoinColumn(name = "test_id")
    private Test test;

    @JsonBackReference
    public Test getTest()
    {
        return test;
    }

    public void setTest(Test theTest)
    {
        test = theTest;
    }


}
