package br.com.forumhub.model.entity;

import br.com.forumhub.model.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Perfil {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleEnum nome;

    @ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios;
}
