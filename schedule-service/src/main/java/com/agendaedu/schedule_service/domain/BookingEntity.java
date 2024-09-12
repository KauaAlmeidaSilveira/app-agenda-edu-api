package com.agendaedu.schedule_service.domain;

import com.agendaedu.schedule_service.domain.dto.BookingDTO;
import com.agendaedu.schedule_service.domain.dto.enums.IsDisabled;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private LocalTime createdAt;

    private LocalTime disabledAt;

    @ManyToOne
    private Local local;

    @ManyToOne
    private User user;

    public BookingEntity(BookingDTO bookingDTO) {
        this.id = bookingDTO.getId();
        this.date = bookingDTO.getDate();
        this.checkIn = bookingDTO.getCheckIn();
        this.checkOut = bookingDTO.getCheckOut();
    }
}
