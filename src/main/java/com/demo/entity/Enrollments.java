package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long faculty_user_id;
    private Long learner_user_id;
    private Long course_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFaculty_user_id() {
		return faculty_user_id;
	}
	public void setFaculty_user_id(Long faculty_user_id) {
		this.faculty_user_id = faculty_user_id;
	}
	public Long getLearner_user_id() {
		return learner_user_id;
	}
	public void setLearner_user_id(Long learner_user_id) {
		this.learner_user_id = learner_user_id;
	}
	public Long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

    
}
