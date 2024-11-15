package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.ParticipationRequestDTO;
import fr.projet.duo.optimisation.Entity.ParticipationRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParticipationRequestMapper {

    ParticipationRequest toEntity(ParticipationRequest participationRequest);
    ParticipationRequestDTO toDTO(ParticipationRequestDTO participationRequestDTO);

    List<ParticipationRequestDTO> toDTOs(List<ParticipationRequest> participationRequests);
    List<ParticipationRequest> toEntities(List<ParticipationRequestDTO> participationRequestDTOs);
}
