package com.agendaedu.schedule_service.controllers.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "Senha é obrigatória")
        String password,
        @NotBlank(message = "A Senha de confirmação é obrigatória")
        String confirmPassword,
        @NotBlank(message = "Nome é obrigatório")
        String name) {
}
