package com.agendaedu.schedule_service.repositories;

import com.agendaedu.schedule_service.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<List<Course>> findAllByDegree(String degree);
}
