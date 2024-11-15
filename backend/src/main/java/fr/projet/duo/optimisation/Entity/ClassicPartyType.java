package fr.projet.duo.optimisation.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassicPartyType extends PartyType {
    // Présence de musique
    private boolean hasMusic;

    // Type de musique (optionnel)
    private String musicType;

}

