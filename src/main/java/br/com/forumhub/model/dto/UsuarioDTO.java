package br.com.forumhub.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public record UsuarioDTO(
    @NotBlank
    String nome,
    @NotBlank
    String email,
    @NotBlank
    String senha,
    @NotNull
    List<PerfilDTO> perfis
){}
