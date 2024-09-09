package com.agendaedu.schedule_service.projections;

import java.time.LocalDate;
import java.time.LocalTime;

public interface BookingResponseProjection {
    Long getId();

    String getCourseName();

    LocalDate getDate();

    LocalTime getCheckIn();

    LocalTime getCheckOut();

    String getLocalName();

    Long getUserId();
}
