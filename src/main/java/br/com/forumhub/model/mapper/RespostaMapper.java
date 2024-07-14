package br.com.forumhub.model.mapper;

import br.com.forumhub.model.dto.RespostaDTO;
import br.com.forumhub.model.entity.Resposta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RespostaMapper {
    Resposta dtoToEntity(RespostaDTO respostaDTO);
    RespostaDTO entityToDTO(Resposta resposta);
}
