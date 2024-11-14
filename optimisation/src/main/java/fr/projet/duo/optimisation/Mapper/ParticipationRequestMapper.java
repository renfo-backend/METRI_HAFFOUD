package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.ParticipationRequestDTO;
import fr.projet.duo.optimisation.Entity.ParticipationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParticipationRequestMapper {

    ParticipationRequest toEntity(ParticipationRequest participationRequest);
    ParticipationRequestDTO toDTO(ParticipationRequestDTO participationRequestDTO);
}
