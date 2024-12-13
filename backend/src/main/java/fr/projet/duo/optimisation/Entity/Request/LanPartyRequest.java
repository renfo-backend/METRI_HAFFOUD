package fr.projet.duo.optimisation.Entity.Request;

import fr.projet.duo.optimisation.DTO.LanPartyDetailsDTO;
import fr.projet.duo.optimisation.DTO.PartyDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanPartyRequest {
    private PartyDTO party;
    private LanPartyDetailsDTO lanDetails;
}
