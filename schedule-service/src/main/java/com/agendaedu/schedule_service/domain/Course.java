package com.agendaedu.schedule_service.domain;

import com.agendaedu.schedule_service.domain.dto.CourseDTO;
import com.agendaedu.schedule_service.domain.dto.enums.CourseDegree;
import com.agendaedu.schedule_service.domain.dto.enums.IsDisabled;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private CourseDegree degree;

    private IsDisabled isDisabled;

    @OneToMany(mappedBy = "course")
    private List<BookingEntity> bookings;

    public Course(CourseDTO courseDTO) {
        this.id = courseDTO.getId();
        this.name = courseDTO.getName();
    }
}
