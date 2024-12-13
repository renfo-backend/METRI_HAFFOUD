package fr.projet.duo.optimisation.Repository;

import fr.projet.duo.optimisation.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
