package com.agendaedu.schedule_service.domain.course;

import com.agendaedu.schedule_service.domain.booking.BookingEntity;
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

    @OneToMany(mappedBy = "course")
    private List<BookingEntity> bookings;

    public Course(CourseDTO courseDTO) {
        this.id = courseDTO.getId();
        this.name = courseDTO.getName();
    }
}
