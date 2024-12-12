package fr.projet.duo.optimisation.Repository;

import fr.projet.duo.optimisation.Entity.ParticipationRequest;
import fr.projet.duo.optimisation.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationRequestRepository extends JpaRepository<ParticipationRequest, Long> {
    @Query("SELECT pr FROM ParticipationRequest pr WHERE pr.party.organizer = :users and pr.party.id = :id")
    List<ParticipationRequest> findByUsers(Users users,Long id);

    List<ParticipationRequest> findByUsers(Users users);

}
