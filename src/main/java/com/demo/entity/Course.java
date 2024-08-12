package com.demo.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String course_id;
    private String course_name;
    private LocalDate start_dt;
    private LocalDate end_dt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public LocalDate getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(LocalDate start_dt) {
		this.start_dt = start_dt;
	}
	public LocalDate getEnd_dt() {
		return end_dt;
	}
	public void setEnd_dt(LocalDate end_dt) {
		this.end_dt = end_dt;
	}
    
    

}
