package com.agendaedu.schedule_service.domain;

import com.agendaedu.schedule_service.domain.dto.LocalDTO;
import com.agendaedu.schedule_service.domain.dto.enums.IsDisabled;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_local")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    private IsDisabled isDisabled;

    @OneToMany(mappedBy = "local")
    private List<BookingEntity> booking;

    public Local(LocalDTO localDTO) {
        this.id = localDTO.getId();
        this.name = localDTO.getName();
    }
}
