package com.agendaedu.schedule_service.controllers;

import com.agendaedu.schedule_service.domain.course.CoursesGroupDTO;
import com.agendaedu.schedule_service.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CoursesGroupDTO>> findAll() {
        return ResponseEntity.ok(this.courseService.findAll());
    }

}
