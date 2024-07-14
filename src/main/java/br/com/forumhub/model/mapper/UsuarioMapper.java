package br.com.forumhub.model.mapper;

import br.com.forumhub.model.dto.UsuarioDTO;
import br.com.forumhub.model.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario dtoToEntity(UsuarioDTO usuarioDTO);
    UsuarioDTO entityToDTO(Usuario usuario);
}
