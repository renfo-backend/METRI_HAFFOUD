package fr.projet.duo.optimisation.Entity.Request;

import fr.projet.duo.optimisation.DTO.BoardGamesPartyDetailsDTO;
import fr.projet.duo.optimisation.DTO.PartyDTO;
import fr.projet.duo.optimisation.DTO.PartyTypeDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardGamesPartyRequest extends PartyTypeDTO {
    private PartyDTO party;
    private BoardGamesPartyDetailsDTO boardGamesDetails;
}
