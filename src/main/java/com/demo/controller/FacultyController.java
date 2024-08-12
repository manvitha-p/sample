package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Faculty;
import com.demo.service.FacultyService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public String getAllFaculty(Model model) {
        List<Faculty> facultyList = facultyService.getAllFaculty();
        model.addAttribute("facultyList", facultyList);
        return "faculty_list";
    }

    @GetMapping("/{id}")
    public String getFacultyById(@PathVariable Long id, Model model) {
        Faculty faculty = facultyService.getFacultyById(id);
        model.addAttribute("faculty", faculty);
        return "faculty_details";
    }

    @GetMapping("/add")
    public String showAddFacultyForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "add_faculty";
    }

    @PostMapping("/add")
    public String addFaculty(@ModelAttribute Faculty faculty) {
        facultyService.addFaculty(faculty);
        return "redirect:/faculty";
    }

    @GetMapping("/edit/{id}")
    public String showEditFacultyForm(@PathVariable Long id, Model model) {
        Faculty faculty = facultyService.getFacultyById(id);
        model.addAttribute("faculty", faculty);
        return "edit_faculty";
    }

    @PostMapping("/edit/{id}")
    public String updateFaculty(@PathVariable Long id, @ModelAttribute Faculty updatedFaculty) {
        facultyService.updateFaculty(id, updatedFaculty);
        return "redirect:/faculty";
    }

    @GetMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return "redirect:/faculty";
    }
}



