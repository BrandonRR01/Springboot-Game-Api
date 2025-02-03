package com.proyectos.game_service.entity;

import com.proyectos.game_service.commons.dto.AbstractClass;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table (name = "games")
public class Game extends AbstractClass {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long userId;

}
