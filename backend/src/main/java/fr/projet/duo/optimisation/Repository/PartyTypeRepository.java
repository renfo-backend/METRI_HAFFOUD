package fr.projet.duo.optimisation.Repository;

import fr.projet.duo.optimisation.Entity.PartyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PartyTypeRepository extends JpaRepository<PartyType, Long> {
    PartyType findByName(String name);
}
