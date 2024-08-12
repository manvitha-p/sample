package com.demo.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Enrollments;

@Repository
public interface EnrollmentsRepository extends JpaRepository<Enrollments, Long> {
	
}
