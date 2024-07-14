package br.com.forumhub.model.mapper;

import br.com.forumhub.model.dto.TopicoDTO;
import br.com.forumhub.model.entity.Topico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TopicoMapper {

    TopicoMapper MAPPER = Mappers.getMapper(TopicoMapper.class);
    Topico dtoToEntity(TopicoDTO topicoDTO);
    TopicoDTO entityToDTO(Topico topico);

    List<TopicoDTO> listEntitiesToListDTO(List<Topico> topicoList);
    List<Topico> listDTOToListEntities(List<TopicoDTO> topicoDTOList);
}
