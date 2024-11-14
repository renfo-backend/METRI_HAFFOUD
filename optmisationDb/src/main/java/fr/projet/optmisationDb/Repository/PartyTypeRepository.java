package fr.projet.optmisationDb.Repository;

import fr.projet.optmisationDb.Entity.PartyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartyTypeRepository extends JpaRepository<PartyType, Long> {
    PartyType findByName(String name);
}
