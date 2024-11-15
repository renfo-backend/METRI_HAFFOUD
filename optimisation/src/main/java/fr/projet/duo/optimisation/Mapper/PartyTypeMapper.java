package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.PartyTypeDTO;
import fr.projet.duo.optimisation.Entity.PartyType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface PartyTypeMapper {

    PartyTypeDTO partyTypeToPartyTypeDTO(PartyType partyType);

    List<PartyTypeDTO> partyTypesToPartyTypeDTOs(List<PartyType> partyTypes);

    PartyType partyTypeDTOToPartyType(PartyTypeDTO partyTypeDTO);

    List<PartyType> partyTypeDTOsToPartyTypes(List<PartyTypeDTO> partyTypeDTOs);
}
