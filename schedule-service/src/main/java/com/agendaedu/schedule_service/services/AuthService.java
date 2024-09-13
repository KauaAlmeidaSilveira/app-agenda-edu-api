package com.agendaedu.schedule_service.services;

import com.agendaedu.schedule_service.config.TimeConfig;
import com.agendaedu.schedule_service.domain.User;
import com.agendaedu.schedule_service.domain.dto.UserDTO;
import com.agendaedu.schedule_service.domain.dto.enums.IsDisabled;
import com.agendaedu.schedule_service.domain.dto.enums.UserRole;
import com.agendaedu.schedule_service.domain.dto.request.LoginRequestDTO;
import com.agendaedu.schedule_service.domain.dto.request.RegisterRequestDTO;
import com.agendaedu.schedule_service.domain.dto.response.LoginResponseDTO;
import com.agendaedu.schedule_service.domain.dto.response.RegisterReponseDTO;
import com.agendaedu.schedule_service.infra.security.TokenService;
import com.agendaedu.schedule_service.repositories.UserRepository;
import com.agendaedu.schedule_service.services.exceptions.InvalidCredentialsException;
import com.agendaedu.schedule_service.services.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Conta não encontrada !!"));
    }

    @Transactional(readOnly = true)
    public LoginResponseDTO login(LoginRequestDTO authDTO) {
        User user = (User) this.loadUserByUsername(authDTO.email());
        if (passwordEncoder.matches(authDTO.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return new LoginResponseDTO(user.getEmail(), token);
        } else {
            throw new InvalidCredentialsException("Senha incorreta!!");
        }
    }

    @Transactional
    public RegisterReponseDTO signup(RegisterRequestDTO authDTO) {
        if (this.userRepository.findByEmail(authDTO.email()).isEmpty()) {
            if (authDTO.password().equals(authDTO.confirmPassword())) {
                String encryptedPassword = passwordEncoder.encode(authDTO.password());
                UserDTO user = new UserDTO(new User(authDTO.email(), encryptedPassword, authDTO.name(), UserRole.USER));
                this.userService.insert(user);
                return new RegisterReponseDTO(authDTO.email(), authDTO.name());
            } else {
                throw new InvalidCredentialsException("As senhas não coincidem !!");
            }
        } else {
            throw new UserAlreadyExistsException("Conta já existente com este email.");
        }
    }

    @Transactional
    public void forgotPassword(String email, String newPassword, String confirmNewPassword) {
        User user = (User) this.loadUserByUsername(email);

        if (!newPassword.equals(confirmNewPassword)) {
            throw new InvalidCredentialsException("As senhas não coincidem !!");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        user.setUpdatedAt(LocalTime.now(TimeConfig.ZONE_ID));
        this.userRepository.save(user);
    }

    @Transactional
    public void updateToIsDisabled(String email) {
        User user = (User) this.loadUserByUsername(email);
        user.setIsDisabled(IsDisabled.TRUE);
        user.setDisabledAt(LocalTime.now(TimeConfig.ZONE_ID));
        this.userRepository.save(user);
    }

}
