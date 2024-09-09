package com.agendaedu.schedule_service.controllers;

import com.agendaedu.schedule_service.domain.local.LocalDTO;
import com.agendaedu.schedule_service.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locals")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping
    public ResponseEntity<List<LocalDTO>> findAll() {
        return ResponseEntity.ok(this.localService.findAll());
    }
}
