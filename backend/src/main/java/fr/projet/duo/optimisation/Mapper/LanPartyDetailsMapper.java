package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.LanPartyDetailsDTO;
import fr.projet.duo.optimisation.Entity.LANPartyType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanPartyDetailsMapper {

    LanPartyDetailsDTO toDTO(LANPartyType lanPartyDetailsDTO);
    LANPartyType toEntity(LanPartyDetailsDTO lanPartyDetailsDTO);
}
