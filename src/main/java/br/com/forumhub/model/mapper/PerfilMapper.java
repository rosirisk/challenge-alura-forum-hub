package br.com.forumhub.model.mapper;

import br.com.forumhub.model.dto.PerfilDTO;
import br.com.forumhub.model.entity.Perfil;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PerfilMapper {
    Perfil dtoToEntity(PerfilDTO perfilDTO);
    PerfilDTO entityToDTO(Perfil perfil);
}
