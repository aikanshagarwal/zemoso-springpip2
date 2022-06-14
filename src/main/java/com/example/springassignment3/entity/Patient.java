package com.example.springassignment3.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="patient")
@Getter
@Setter
@NoArgsConstructor
public class Patient
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

    @ManyToMany
    @JoinTable(name = "patient_test",joinColumns = @JoinColumn(name = "patient_id"),inverseJoinColumns = @JoinColumn(name = "test_id"))
    private List<Test> tests;

}
