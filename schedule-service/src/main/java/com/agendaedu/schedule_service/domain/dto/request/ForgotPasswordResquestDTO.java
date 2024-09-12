package com.agendaedu.schedule_service.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ForgotPasswordResquestDTO(
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "Senha é obrigatória")
        String newPassword,
        @NotBlank(message = "Confirmação senha é obrigatória")
        String confirmNewPassword) {
}
