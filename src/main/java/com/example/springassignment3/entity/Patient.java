package com.example.springassignment3.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

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
