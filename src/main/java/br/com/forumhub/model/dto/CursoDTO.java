package br.com.forumhub.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record CursoDTO (
    @NotBlank
    String nome,
    @NotBlank
    String categoria){}
