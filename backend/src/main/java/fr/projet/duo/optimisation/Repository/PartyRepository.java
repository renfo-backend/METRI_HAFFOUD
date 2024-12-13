package fr.projet.duo.optimisation.Repository;

import fr.projet.duo.optimisation.Entity.Party;
import fr.projet.duo.optimisation.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    @Query("SELECT p FROM Party p WHERE " +
            "p.organizer != :users AND " +
            "(:capacity = 0 OR p.capacity >= :capacity) AND " +
            "(:location IS NULL OR :location = '' OR p.address.location LIKE %:location%) AND " +
            "(:isPaid IS NULL OR p.isPaid = :isPaid) AND " +
            "p.isPublished = true AND " +
            "(:dateParty IS NULL OR :dateParty = '' OR p.dateParty LIKE %:dateParty%) AND " +
            "(:partyType IS NULL OR :partyType = '' OR p.partyType.name LIKE %:partyType%)")
    List<Party> findPartiesWithOptionalPaymentFilter(
            @Param("capacity") Integer capacity,
            @Param("location") String location,
            @Param("isPaid") Boolean isPaid,
            @Param("dateParty") String dateParty,
            @Param("partyType") String partyType,
            @Param("users") Users users
    );

    @Query("SELECT p FROM Party p JOIN p.participationRequests pr WHERE pr.users.id = :userId AND pr.status = 'ACCEPTED' ")
    List<Party> findUpcomingPartiesByUserId(@Param("userId") Long userId);



    List<Party>findByOrganizerId(Long id);
    @Query("SELECT p FROM Party p WHERE p.organizer.id != :user")
    List<Party>findAllParties(Users user);
}
