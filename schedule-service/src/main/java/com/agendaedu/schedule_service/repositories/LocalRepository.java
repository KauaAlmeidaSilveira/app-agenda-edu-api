package com.agendaedu.schedule_service.repositories;

import com.agendaedu.schedule_service.domain.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {
    Optional<Local> findByName(String name);
}
