package com.agendaedu.schedule_service.domain.dto;

import com.agendaedu.schedule_service.domain.Local;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalDTO {
    private Long id;
    private String name;

    public LocalDTO(Local local) {
        this.id = local.getId();
        this.name = local.getName();
    }
}
