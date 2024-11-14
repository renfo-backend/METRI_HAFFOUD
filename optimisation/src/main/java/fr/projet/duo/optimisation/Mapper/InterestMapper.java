package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.InterestDTO;
import fr.projet.duo.optimisation.Entity.Interest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsersMapper.class}) // Utiliser NotificationMapper pour éviter la récursion.
public interface InterestMapper {
    InterestMapper INSTANCE = Mappers.getMapper(InterestMapper.class);
    @Mapping(target = "users", ignore = true) // Ignorer pour éviter la récursion

    InterestDTO toDTO(Interest interest);
    List<InterestDTO> toDTOs(List<Interest> interests);
    @Mapping(target = "users", ignore = true) // Ignorer pour éviter la récursion
    Interest toEntity(InterestDTO interestDTO);
    List<Interest> toEntities(List<InterestDTO> interestDTOs);

}
