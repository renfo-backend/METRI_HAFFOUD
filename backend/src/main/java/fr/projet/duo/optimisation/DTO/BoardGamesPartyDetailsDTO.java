package fr.projet.duo.optimisation.DTO;

import fr.projet.duo.optimisation.Entity.PartyType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardGamesPartyDetailsDTO extends PartyTypeDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private List<String> boardGames;  // Jeux de société prévus par l'organisateur

    private boolean participantsCanBringGames;  // Les participants peuvent-ils apporter des jeux?

}
