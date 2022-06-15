package com.example.springassignment3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test")
@Getter
@Setter
@NoArgsConstructor
public class Test
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "test")
    private List<Patient> patients;

    @JsonManagedReference
    public List<Patient> getPatients()
    {
        return patients;
    }

    public void setPatients(List<Patient> patientList)
    {
        patients = patientList;
    }

}
