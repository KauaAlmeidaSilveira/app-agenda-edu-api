package com.agendaedu.schedule_service.domain.booking;

import com.agendaedu.schedule_service.projections.BookingProjection;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class BookingDTO {
    private Long id;

    @NotNull(message = "O local é obrigatório")
    @Min(value = 1, message = "O local é obrigatório")
    private Long localId;

    @NotNull(message = "A data é obrigatória")
    private LocalDate date;

    @NotNull(message = "O horário de check-in é obrigatório")
    private LocalTime checkIn;

    @NotNull(message = "O horário de check-out é obrigatório")
    private LocalTime checkOut;

    @NotNull(message = "O curso é obrigatório")
    @Min(value = 1, message = "O curso é obrigatório")
    private Long courseId;

    private IsDisabled isDisabled;
    private IsExpired isExpired;

    private Long userId;

    public BookingDTO(BookingEntity bookingEntity) {
        this.id = bookingEntity.getId();
        this.localId = bookingEntity.getLocal().getId();
        this.date = bookingEntity.getDate();
        this.checkIn = bookingEntity.getCheckIn();
        this.checkOut = bookingEntity.getCheckOut();
        this.courseId = bookingEntity.getCourse().getId();
        this.isDisabled = bookingEntity.getIsDisabled();
        this.isExpired = bookingEntity.getIsExpired();
        this.userId = bookingEntity.getUser().getId();
    }

    public BookingDTO(BookingProjection bookingProjection) {
        this.id = bookingProjection.getId();
        this.localId = bookingProjection.getLocalId();
        this.date = bookingProjection.getDate();
        this.checkIn = bookingProjection.getCheckIn();
        this.checkOut = bookingProjection.getCheckOut();
        this.courseId = bookingProjection.getCourseId();
        this.userId = bookingProjection.getUserId();
    }
}
