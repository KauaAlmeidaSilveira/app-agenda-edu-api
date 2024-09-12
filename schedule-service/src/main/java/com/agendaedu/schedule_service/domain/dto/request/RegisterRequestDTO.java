package com.agendaedu.schedule_service.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterRequestDTO(
        @NotBlank(message = "Email é obrigatório")
        @Pattern(
                regexp = "^[A-Za-z0-9._%+-]+@drummond\\.com\\.br$",
                message = "Utilize o email da Instituição"
        )
        String email,
        @NotBlank(message = "Senha é obrigatória")
        String password,
        @NotBlank(message = "A Senha de confirmação é obrigatória")
        String confirmPassword,
        @NotBlank(message = "Nome é obrigatório")
        String name) {
}
