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

import com.demo.entity.Enrollments;
import com.demo.service.EnrollmentsService;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentsController {
    private final EnrollmentsService enrollmentsService;

    @Autowired
    public EnrollmentsController(EnrollmentsService enrollmentsService) {
        this.enrollmentsService = enrollmentsService;
    }

    @GetMapping
    public String getAllEnrollments(Model model) {
        List<Enrollments> enrollmentsList = enrollmentsService.getAllEnrollments();
        model.addAttribute("enrollmentsList", enrollmentsList);
        return "enrollments_list";
    }

    @GetMapping("/{course_id}")
    public String getEnrollmentsByCourseId(@PathVariable Long course_id, Model model) {
      //  List<Enrollments> enrollmentsList = enrollmentsService.getEnrollmentsByCourseId(course_id);
   //     model.addAttribute("enrollmentsList", enrollmentsList);
        return "enrollments_list";
    }

    @GetMapping("/add")
    public String showAddEnrollmentForm(Model model) {
        model.addAttribute("enrollment", new Enrollments());
        return "add_enrollment";
    }

    @PostMapping("/add")
    public String addEnrollment(@ModelAttribute Enrollments enrollment) {
        enrollmentsService.addEnrollment(enrollment);
        return "redirect:/enrollments";
    }

    @GetMapping("/delete/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        enrollmentsService.deleteEnrollment(id);
        return "redirect:/enrollments";
    }
}
