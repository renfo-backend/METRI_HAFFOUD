package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.InterestDTO;
import fr.projet.duo.optimisation.Entity.Interest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring") // Utiliser NotificationMapper pour éviter la récursion.
public interface InterestMapper {
    InterestMapper INSTANCE = Mappers.getMapper(InterestMapper.class);

    InterestDTO toDTO(Interest interest);
    List<InterestDTO> toDTOs(List<Interest> interests);
    Interest toEntity(InterestDTO interestDTO);
    List<Interest> toEntities(List<InterestDTO> interestDTOs);

}
