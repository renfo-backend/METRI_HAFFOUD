package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.ParticipationRequestDTO;
import fr.projet.duo.optimisation.Entity.ParticipationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsersMapper.class, PartyMapper.class})
public interface ParticipationRequestMapper {

    @Mapping(target = "users.notifications", ignore = true)
    @Mapping(target = "users.interests", ignore = true)
    @Mapping(target = "users.party", ignore = true)
    @Mapping(target = "users.participationRequests", ignore = true)
    @Mapping(target = "users.organizedParties", ignore = true)
    @Mapping(target = "party.participant", ignore = true)
    @Mapping(target = "party.messages", ignore = true)
    @Mapping(target = "party.participationRequests", ignore = true)
    ParticipationRequestDTO toDTO(ParticipationRequest participationRequest);

    @Mapping(target = "users.notifications", ignore = true)
    @Mapping(target = "users.interests", ignore = true)
    @Mapping(target = "users.party", ignore = true)
    @Mapping(target = "users.participationRequests", ignore = true)
    @Mapping(target = "users.organizedParties", ignore = true)
    @Mapping(target = "party.participant", ignore = true)
    @Mapping(target = "party.messages", ignore = true)
    @Mapping(target = "party.participationRequests", ignore = true)
    ParticipationRequest toEntity(ParticipationRequestDTO participationRequestDTO);

    List<ParticipationRequestDTO> toDTOs(List<ParticipationRequest> participationRequests);

    List<ParticipationRequest> toEntities(List<ParticipationRequestDTO> participationRequestDTOs);
}

