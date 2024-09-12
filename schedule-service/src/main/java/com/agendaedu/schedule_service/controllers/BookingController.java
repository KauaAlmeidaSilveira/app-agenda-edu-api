package com.agendaedu.schedule_service.controllers;

import com.agendaedu.schedule_service.domain.dto.BookingDTO;
import com.agendaedu.schedule_service.projections.BookingResponseProjection;
import com.agendaedu.schedule_service.services.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("/new")
    public ResponseEntity<BookingDTO> insert(@RequestBody @Valid BookingDTO bookingDTO) {
        return ResponseEntity.ok(service.insert(bookingDTO));
    }

    @PatchMapping("/disable/{bookingId}")
    public ResponseEntity<BookingDTO> disableBookingById(@PathVariable Long bookingId) {
        return ResponseEntity.ok(service.disableBookingById(bookingId));
    }

    @GetMapping("/user/bookings")
    public ResponseEntity<List<BookingResponseProjection>> findBookingsByUserId() {
        return ResponseEntity.ok(service.findBookingsByUserId());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDTO> findById(@PathVariable Long bookingId) {
        return ResponseEntity.ok(service.findById(bookingId));
    }

    @GetMapping("/checkin/{date}/{localId}")
    public ResponseEntity<List<LocalTime>> findPossiblesCheckIn(
            @PathVariable LocalDate date,
            @PathVariable Long localId) {
        List<BookingDTO> bookingFiltered = service.findBookingsByDateAndLocal(date, localId);
        List<LocalTime> possiblesCheckIn = service.findPossiblesCheckIn(bookingFiltered);
        return ResponseEntity.ok(possiblesCheckIn);
    }

    @GetMapping("/checkout/{date}/{localId}")
    public ResponseEntity<List<LocalTime>> findPossiblesCheckOutWithCheckIn(
            @PathVariable LocalDate date,
            @PathVariable Long localId,
            @RequestParam LocalTime checkInSelected) {
        List<BookingDTO> bookingFiltered = service.findBookingsByDateAndLocal(date, localId);
        List<LocalTime> possiblesCheckOutWithCheckIn = service.findPossiblesCheckOutWithCheckIn(bookingFiltered, checkInSelected);
        return ResponseEntity.ok(possiblesCheckOutWithCheckIn);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
