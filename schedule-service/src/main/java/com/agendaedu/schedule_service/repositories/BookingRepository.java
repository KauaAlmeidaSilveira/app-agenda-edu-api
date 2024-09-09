package com.agendaedu.schedule_service.repositories;

import com.agendaedu.schedule_service.domain.booking.BookingEntity;
import com.agendaedu.schedule_service.projections.BookingProjection;
import com.agendaedu.schedule_service.projections.BookingResponseProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    @Query(nativeQuery = true,
            value = """
                        SELECT *
                        FROM
                            TB_BOOKING
                        WHERE
                            LOCAL_ID = :localId
                        AND
                            DATE = :date
                        AND
                            is_disabled = 0
                        AND
                            is_expired = 0
                    """
    )
    List<BookingProjection> findBookingByDateAndLocal(LocalDate date, Long localId);

    @Query(nativeQuery = true,
            value = """
                        SELECT
                            b.id,
                            b.date,
                            b.check_in,
                            b.check_out,
                            l.name as local_name,
                            c.name as course_name,
                            b.user_id
                        FROM
                            TB_BOOKING b
                        JOIN
                            TB_LOCAL l ON b.local_id = l.id
                        JOIN
                            TB_COURSE c ON b.course_id = c.id
                        WHERE
                            b.user_id = :id
                        AND
                            b.is_disabled = 0
                        AND
                            b.is_expired = 0
                        ORDER BY
                            b.date ASC,
                            b.check_in ASC,
                            b.check_out ASC;
                    """
    )
    List<BookingResponseProjection> findByUserId(Long id);


    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value =
                    """
                                UPDATE tb_booking
                                SET is_expired = 1
                                WHERE date < :currentDate
                            """
    )
    void expireOldBookings(LocalDate currentDate);

}


