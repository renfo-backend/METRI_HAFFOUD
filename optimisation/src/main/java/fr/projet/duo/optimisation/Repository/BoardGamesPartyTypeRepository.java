package fr.projet.duo.optimisation.Repository;

import fr.projet.duo.optimisation.Entity.BoardGamesPartyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardGamesPartyTypeRepository extends JpaRepository<BoardGamesPartyType, Long> {
}
