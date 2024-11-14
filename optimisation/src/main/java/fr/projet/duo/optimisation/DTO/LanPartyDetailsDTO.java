package fr.projet.duo.optimisation.DTO;

import fr.projet.duo.optimisation.Entity.PartyType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanPartyDetailsDTO extends PartyTypeDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    @ElementCollection
    private List<String> videoGames=new ArrayList<>();

    @ElementCollection
    private List<String> platforms=new ArrayList<>();

    private boolean participantsCanSuggestGames;
}
