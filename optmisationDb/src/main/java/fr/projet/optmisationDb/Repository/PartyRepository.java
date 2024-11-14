package fr.projet.optmisationDb.Repository;

import fr.projet.optmisationDb.Entity.Party;
import fr.projet.optmisationDb.Entity.PartyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    List<Party> findByCapacityGreaterThanEqualAndLocationContainingAndPartyTypeAndIsPaidAndDatePartyContaining(Integer capacity, String location, PartyType partyType, Boolean paid, String date_party);
}
