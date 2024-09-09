package com.agendaedu.schedule_service.domain.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursesGroupDTO {
    private String name;
    private List<CourseDTO> courses = new ArrayList<>();
}
