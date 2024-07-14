package br.com.forumhub.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public record TopicoDTO(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        LocalDateTime dataCriacao,
        @NotBlank
        String status,
        UsuarioDTO autor,
        CursoDTO curso) {
}
