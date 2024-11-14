package fr.projet.duo.optimisation.Entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LANPartyType extends PartyType {
    @ElementCollection
    private List<String> videoGames=new ArrayList<>();

    @ElementCollection
    private List<String> platforms=new ArrayList<>();

    private boolean participantsCanSuggestGames;

}

