package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.domain.User;
import com.agendaedu.schedule_service.domain.dto.UserDTO;
import com.agendaedu.schedule_service.domain.dto.enums.IsDisabled;
import com.agendaedu.schedule_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public UserDTO insert(UserDTO userDTO) {
        User user = new User(userDTO);
        user.setCreatedAt(LocalTime.now());
        user.setIsDisabled(IsDisabled.FALSE);
        return new UserDTO(this.repository.save(user));
    }

    public UserDTO findById(Long id) {
        return new UserDTO(repository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Conta não encontrada !!")));
    }

}
