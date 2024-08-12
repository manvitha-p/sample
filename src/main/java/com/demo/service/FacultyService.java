package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Faculty;
import com.demo.repository.FacultyRepository;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public void addFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public void updateFaculty(Long id, Faculty updatedFaculty) {
        Faculty existingFaculty = facultyRepository.findById(id).orElse(null);
        if (existingFaculty != null) {
            existingFaculty.setUser_id(updatedFaculty.getUser_id());
            existingFaculty.setFirstname(updatedFaculty.getFirstname());
            existingFaculty.setLastname(updatedFaculty.getLastname());
            facultyRepository.save(existingFaculty);
        }
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}


