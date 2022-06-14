package com.example.springassignment3.repository;

import com.example.springassignment3.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test , Integer>
{
}
