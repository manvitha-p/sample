package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.entity.Learners;
import com.demo.repository.LearnersRepository;

@Service
public class LearnersService {

    @Autowired
    private LearnersRepository learnersRepository;

    @Cacheable(value = "learnersCache", key = "'allLearners'")
    public List<Learners> getAllLearners() {
        return learnersRepository.findAll();
    }

    public Optional<Learners> getLearnerById(Long id) {
        return learnersRepository.findById(id);
    }

    @CacheEvict(value = "learnersCache", key = "'allLearners'")
    public Learners createLearner(Learners learner) {
        return learnersRepository.save(learner);
    }

    @CacheEvict(value = "learnersCache", key = "'allLearners'")
    public Learners updateLearner(Long id, Learners learner) {
        if (learnersRepository.existsById(id)) {
            learner.setId(id); // Ensure the correct ID is set
            return learnersRepository.save(learner);
        }
        return null; // Learner not found
    }

    @CacheEvict(value = "learnersCache", key = "'allLearners'")
    public void deleteLearner(Long id) {
        learnersRepository.deleteById(id);
    }
}


 


