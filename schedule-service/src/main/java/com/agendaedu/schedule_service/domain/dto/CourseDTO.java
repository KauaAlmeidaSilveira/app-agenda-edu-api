package com.agendaedu.schedule_service.domain.dto;

import com.agendaedu.schedule_service.domain.Course;
import com.agendaedu.schedule_service.domain.dto.enums.CourseDegree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO implements Comparable<CourseDTO> {
    private Long id;
    private String name;
    private CourseDegree degree;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.degree = course.getDegree();
    }

    @Override
    public int compareTo(CourseDTO o) {
        return this.name.compareTo(o.getName());
    }
}
