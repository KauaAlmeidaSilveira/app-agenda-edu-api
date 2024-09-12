package com.agendaedu.schedule_service.domain.dto;

import com.agendaedu.schedule_service.domain.User;
import com.agendaedu.schedule_service.domain.dto.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "O email é obrigatório")
    private String email;
    @NotBlank(message = "A senha é obrigatória")
    private String password;
    private String name;
    private String role;

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
        this.role = Objects.equals(user.getRole(), UserRole.ADMIN) ? UserRole.ADMIN.getRole() : UserRole.USER.getRole();
    }
}
