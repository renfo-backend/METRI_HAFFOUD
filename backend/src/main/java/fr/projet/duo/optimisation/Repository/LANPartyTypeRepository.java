package fr.projet.duo.optimisation.Repository;

import fr.projet.duo.optimisation.Entity.LANPartyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LANPartyTypeRepository extends JpaRepository<LANPartyType, Long> {
}
