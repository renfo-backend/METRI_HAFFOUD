package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.BoardGamesPartyDetailsDTO;
import fr.projet.duo.optimisation.Entity.BoardGamesPartyType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardGamesPartyDetailsMapper {

    BoardGamesPartyDetailsDTO toEntity(BoardGamesPartyType boardGamesPartyType);
    BoardGamesPartyType toDTO(BoardGamesPartyDetailsDTO boardGamesPartyDetailsDTO);
}
