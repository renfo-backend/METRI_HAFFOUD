package fr.projet.duo.optimisation.DTO;

import fr.projet.duo.optimisation.Entity.PartyType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassicPartyDetailsDTO extends PartyType {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private boolean hasMusic;

    // Type de musique (optionnel)
    private String musicType;
}
