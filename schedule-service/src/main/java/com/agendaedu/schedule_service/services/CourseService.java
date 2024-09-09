package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.domain.course.Course;
import com.agendaedu.schedule_service.domain.course.CourseDTO;
import com.agendaedu.schedule_service.domain.course.CourseDegree;
import com.agendaedu.schedule_service.domain.course.CoursesGroupDTO;
import com.agendaedu.schedule_service.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public List<CoursesGroupDTO> findAll() {
        List<Course> result = this.courseRepository.findAll();

        CoursesGroupDTO infantil = new CoursesGroupDTO("Infantil", this.filterAndMapCourses(result, CourseDegree.INFANTIL));
        CoursesGroupDTO fundamental = new CoursesGroupDTO("Fundamental", this.filterAndMapCourses(result, CourseDegree.FUNDAMENTAL));
        CoursesGroupDTO medio = new CoursesGroupDTO("Médio", this.filterAndMapCourses(result, CourseDegree.MEDIO));

        return new ArrayList<>(List.of(infantil, fundamental, medio));
    }

    @Transactional(readOnly = true)
    public CourseDTO findById(Long id) {
        return new CourseDTO(this.courseRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Turma não encontrada !!")));
    }

    private List<CourseDTO> filterAndMapCourses(List<Course> courses, CourseDegree degree) {
        return courses
                .stream()
                .filter(course -> course.getDegree() == degree)
                .map(CourseDTO::new)
                .sorted()
                .toList();
    }

}
