package fr.projet.duo.optimisation.Entity.Request;

import fr.projet.duo.optimisation.DTO.ClassicPartyDetailsDTO;
import fr.projet.duo.optimisation.DTO.PartyDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassicPartyRequest {
    private PartyDTO party;
    private ClassicPartyDetailsDTO classicDetails;
}

