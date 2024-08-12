package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Course;
import com.demo.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Long id, Course updatedCourse) {
        Course existingCourse = courseRepository.findById(id).orElse(null);
        if (existingCourse != null) {
            existingCourse.setCourse_id(updatedCourse.getCourse_id());
            existingCourse.setCourse_name(updatedCourse.getCourse_name());
            existingCourse.setStart_dt(updatedCourse.getStart_dt());
            existingCourse.setEnd_dt(updatedCourse.getEnd_dt());
            courseRepository.save(existingCourse);
        }
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
