package fr.projet.optmisationDb.Mapper;

import fr.projet.optmisationDb.DTO.PartyDTO;
import fr.projet.optmisationDb.Entity.Party;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
//@Mapper(componentModel = "spring", uses = {PartyTypeMapper.class, UsersMapper.class})
public interface PartyMapper {

    PartyDTO toDTO(Party party);
    Party toEntity(PartyDTO partyDTO);
}
