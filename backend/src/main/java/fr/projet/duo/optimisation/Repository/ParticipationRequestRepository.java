package fr.projet.duo.optimisation.Repository;

import fr.projet.duo.optimisation.Entity.ParticipationRequest;
import fr.projet.duo.optimisation.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationRequestRepository extends JpaRepository<ParticipationRequest, Long> {

}
