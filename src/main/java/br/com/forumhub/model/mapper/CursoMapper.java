package br.com.forumhub.model.mapper;

import br.com.forumhub.model.dto.CursoDTO;
import br.com.forumhub.model.entity.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoMapper MAPPER = Mappers.getMapper(CursoMapper.class);
    Curso dtoToEntity(CursoDTO cursoDTO);
    CursoDTO entityToDTO(Curso curso);
}
