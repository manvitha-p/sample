package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Learners;
import com.demo.service.LearnersService;

@Controller
@RequestMapping("/learners")
public class LearnersController {

    @Autowired
    private LearnersService learnersService;

    @GetMapping
    public String listLearners(Model model) {
        model.addAttribute("learners", learnersService.getAllLearners());
        return "learners";
    }

    @GetMapping("/{id}")
    public String showLearner(@PathVariable Long id, Model model) {
        Optional<Learners> learner = learnersService.getLearnerById(id);
        if (learner.isPresent()) {
            model.addAttribute("learner", learner.get());
            return "learner_details";
        } else {
            return "redirect:/learners";
        }
    }

    @GetMapping("/add")
    public String addLearnerForm(Model model) {
        model.addAttribute("learner", new Learners());
        return "add_learner";
    }

    @PostMapping("/add")
    public String addLearnerSubmit(@ModelAttribute Learners learner) {
        learnersService.createLearner(learner);
        return "redirect:/learners";
    }

    @GetMapping("/edit/{id}")
    public String editLearnerForm(@PathVariable Long id, Model model) {
        Optional<Learners> learner = learnersService.getLearnerById(id);
        if (learner.isPresent()) {
            model.addAttribute("learner", learner.get());
            return "edit_learner";
        } else {
            return "redirect:/learners";
        }
    }

    @PostMapping("/edit/{id}")
    public String editLearnerSubmit(@PathVariable Long id, @ModelAttribute Learners learner) {
        Learners updatedLearner = learnersService.updateLearner(id, learner);
        if (updatedLearner != null) {
            return "redirect:/learners/" + id;
        } else {
            return "redirect:/learners";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteLearner(@PathVariable Long id) {
        learnersService.deleteLearner(id);
        return "redirect:/learners";
    }
}
