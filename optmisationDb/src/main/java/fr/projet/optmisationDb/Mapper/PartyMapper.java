package fr.projet.optmisationDb.Mapper;

import fr.projet.optmisationDb.DTO.PartyDTO;
import fr.projet.optmisationDb.Entity.Party;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
//@Mapper(componentModel = "spring", uses = {PartyTypeMapper.class, UsersMapper.class})
public interface PartyMapper {

    PartyDTO toDTO(Party party);
    List<PartyDTO> toDTOs(List<Party> parties);
    Party toEntity(PartyDTO partyDTO);
    List<Party> toEntities(List<PartyDTO> partyDTOs);
}
