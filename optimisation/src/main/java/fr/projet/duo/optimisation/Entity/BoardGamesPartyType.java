package fr.projet.duo.optimisation.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardGamesPartyType extends PartyType {
    @ElementCollection
    private List<String> boardGames;  // Jeux de société prévus par l'organisateur

    private boolean participantsCanBringGames;  // Les participants peuvent-ils apporter des jeux?

}
