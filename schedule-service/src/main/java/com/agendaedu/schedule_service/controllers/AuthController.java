package com.agendaedu.schedule_service.controllers;

import com.agendaedu.schedule_service.domain.dto.request.ForgotPasswordResquestDTO;
import com.agendaedu.schedule_service.domain.dto.request.LoginRequestDTO;
import com.agendaedu.schedule_service.domain.dto.request.RegisterRequestDTO;
import com.agendaedu.schedule_service.domain.dto.response.LoginResponseDTO;
import com.agendaedu.schedule_service.domain.dto.response.RegisterReponseDTO;
import com.agendaedu.schedule_service.services.AuthService;
import com.agendaedu.schedule_service.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO data) {
        return ResponseEntity.ok(this.authService.login(data));
    }

    @PostMapping("/signup")
    public ResponseEntity<RegisterReponseDTO> register(@Valid @RequestBody RegisterRequestDTO data) {
        RegisterReponseDTO account = this.authService.signup(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}")
                .buildAndExpand(account.email()).toUri();
        return ResponseEntity.created(uri).body(account);
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity forgotPassword(@Valid @RequestBody ForgotPasswordResquestDTO data) {
        this.authService.forgotPassword(data.email(), data.newPassword(), data.confirmNewPassword());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateToIsDisabled/{email}")
    public ResponseEntity updateToIsDisabled(@PathVariable String email) {
        this.authService.updateToIsDisabled(email);
        return ResponseEntity.ok().build();
    }

}
