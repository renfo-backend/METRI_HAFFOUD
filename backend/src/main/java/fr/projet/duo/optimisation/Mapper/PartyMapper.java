package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.PartyDTO;
import fr.projet.duo.optimisation.Entity.Party;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsersMapper.class, MessageMapper.class, ParticipationRequestMapper.class})
public interface PartyMapper {

    @Mapping(target = "participant", ignore = true) // Ignore les participants pour éviter les cycles
    @Mapping(target = "messages", ignore = true) // Ignore les messages
    @Mapping(target = "participationRequests", ignore = true) // Ignore les participations
    PartyDTO toDTO(Party party);

    @Mapping(target = "participant", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "participationRequests", ignore = true)
    List<PartyDTO> toDTOs(List<Party> parties);

    @Mapping(target = "participant", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "participationRequests", ignore = true)
    Party toEntity(PartyDTO partyDTO);

    List<Party> toEntities(List<PartyDTO> partyDTOs);
}

