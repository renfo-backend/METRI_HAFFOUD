package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.ClassicPartyDetailsDTO;
import fr.projet.duo.optimisation.Entity.ClassicPartyType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassicPartyDetailsMapper {

    ClassicPartyDetailsDTO toEntity(ClassicPartyType classicPartyType);
    ClassicPartyType toDTO(ClassicPartyDetailsDTO classicPartyDetailsDTO);

}
