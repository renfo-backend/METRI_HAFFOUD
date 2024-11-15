package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.CycleAvoidingMappingContext;
import fr.projet.duo.optimisation.DTO.PartyDTO;
import fr.projet.duo.optimisation.Entity.Party;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsersMapper.class, MessageMapper.class, ParticipationRequestMapper.class})
public interface PartyMapper {

    PartyDTO toDTO(Party party);
    List<PartyDTO> toDTOs(List<Party> parties);
    Party toEntity(PartyDTO partyDTO);
    List<Party> toEntities(List<PartyDTO> partyDTOs,@Context CycleAvoidingMappingContext context);
}
