package com.agendaedu.schedule_service.domain.booking;

import com.agendaedu.schedule_service.domain.course.Course;
import com.agendaedu.schedule_service.domain.local.Local;
import com.agendaedu.schedule_service.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;

    @ManyToOne
    private Course course;

    private IsDisabled isDisabled;

    private Timestamp createdAt;

    @ManyToOne
    private Local local;

    @ManyToOne
    private User user;

    public BookingEntity(BookingDTO bookingDTO) {
        this.id = bookingDTO.getId();
        this.date = bookingDTO.getDate();
        this.checkIn = bookingDTO.getCheckIn();
        this.checkOut = bookingDTO.getCheckOut();
        this.isDisabled = bookingDTO.getIsDisabled();
    }
}
