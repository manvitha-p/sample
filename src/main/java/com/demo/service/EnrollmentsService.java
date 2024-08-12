package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Enrollments;
import com.demo.repository.EnrollmentsRepository;

@Service
public class EnrollmentsService {
    private final EnrollmentsRepository enrollmentsRepository;

    @Autowired
    public EnrollmentsService(EnrollmentsRepository enrollmentsRepository) {
        this.enrollmentsRepository = enrollmentsRepository;
    }

    public List<Enrollments> getAllEnrollments() {
        return enrollmentsRepository.findAll();
    }

//    public List<Enrollments> getEnrollmentsByCourseId(Long courseId) {
//       return enrollmentsRepository.findByCourse_id(courseId);
//    }

    public void addEnrollment(Enrollments enrollment) {
        enrollmentsRepository.save(enrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentsRepository.deleteById(id);
    }
}
