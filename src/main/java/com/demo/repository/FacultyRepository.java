package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
 
 }

