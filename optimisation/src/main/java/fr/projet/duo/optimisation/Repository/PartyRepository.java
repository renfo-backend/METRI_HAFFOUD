package fr.projet.duo.optimisation.Repository;

import fr.projet.duo.optimisation.Entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    @Query("SELECT p FROM Party p WHERE " +
            "p.capacity >= :capacity AND " +
            "p.address.location LIKE %:location% AND " +
            "(:isPaid IS NULL OR p.isPaid = :isPaid) AND " +
            "p.dateParty LIKE %:dateParty%" +
            " AND " + "(:partyType IS NULL OR p.partyType.name LIKE %:partyType%)" +
            "")
    List<Party> findPartiesWithOptionalPaymentFilter(
            @Param("capacity") Integer capacity,
            @Param("location") String location,
            @Param("isPaid") Boolean isPaid,
            @Param("dateParty") String dateParty,
            @Param("partyType") String partyType
    );
}
