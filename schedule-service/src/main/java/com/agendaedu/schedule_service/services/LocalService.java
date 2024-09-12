package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.domain.Local;
import com.agendaedu.schedule_service.domain.dto.LocalDTO;
import com.agendaedu.schedule_service.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Transactional
    public LocalDTO insert(LocalDTO localDTO) {
        Local local = new Local(localDTO);
        local = this.localRepository.save(local);
        return new LocalDTO(local);
    }

    @Transactional(readOnly = true)
    public List<LocalDTO> findAll() {
        return this.localRepository.findAll().stream().map(LocalDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public LocalDTO findById(Long id) {
        return new LocalDTO(this.localRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Local não encontrado !!")));
    }

}
