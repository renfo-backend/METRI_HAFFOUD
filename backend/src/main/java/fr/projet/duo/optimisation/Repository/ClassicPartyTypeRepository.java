package fr.projet.duo.optimisation.Repository;

import fr.projet.duo.optimisation.Entity.ClassicPartyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassicPartyTypeRepository extends JpaRepository<ClassicPartyType, Long> {
}
