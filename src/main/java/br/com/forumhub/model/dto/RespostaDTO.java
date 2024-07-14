package br.com.forumhub.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record RespostaDTO(

    @NotBlank
    String mensagem,
    TopicoDTO topico,
    LocalDateTime dataCriacao,
    UsuarioDTO autor,
    String solucao
){}
