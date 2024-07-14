package br.com.forumhub.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;


public record PerfilDTO(
    @NotBlank
    String nome){}
