package com.example.springassignment3.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "name")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd" , timezone = "IST")
    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender")
    private String gender;

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
