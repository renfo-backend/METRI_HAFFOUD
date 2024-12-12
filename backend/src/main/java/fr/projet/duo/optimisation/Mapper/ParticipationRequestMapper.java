package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.ParticipationRequestDTO;
import fr.projet.duo.optimisation.Entity.ParticipationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsersMapper.class, PartyMapper.class})
public interface ParticipationRequestMapper {

    // Mapper l'entité vers le DTO en ignorant les relations problématiques
    @Mapping(target = "users.notifications", ignore = true) // Éviter les notifications
    @Mapping(target = "users.interests", ignore = true) // Éviter les intérêts
    @Mapping(target = "users.party", ignore = true) // Éviter les relations bidirectionnelles
    @Mapping(target = "users.participationRequests", ignore = true) // Ignorer les autres demandes
    @Mapping(target = "party.participant", ignore = true) // Ignorer les participant pour éviter les cycles
    @Mapping(target = "party.organizer") // Mapper l'organisateur sans ses relations
    ParticipationRequestDTO toDTO(ParticipationRequest participationRequest);

    // Mapper le DTO vers l'entité en ignorant les relations problématiques
    @Mapping(target = "users.notifications", ignore = true)
    @Mapping(target = "users.interests", ignore = true)
    @Mapping(target = "users.party", ignore = true)
    @Mapping(target = "users.participationRequests", ignore = true)
    @Mapping(target = "party.participant", ignore = true)
    ParticipationRequest toEntity(ParticipationRequestDTO participationRequestDTO);

    List<ParticipationRequestDTO> toDTOs(List<ParticipationRequest> participationRequests);

    List<ParticipationRequest> toEntities(List<ParticipationRequestDTO> participationRequestDTOs);

    /**
     * Mapper personnalisé pour éviter les relations bidirectionnelles lors du mapping des organisateurs.
     */
    @Named("mapOrganizerWithoutRelations")
    default <T> T mapOrganizerWithoutRelations(T organizer) {
        // Ajoutez une logique pour filtrer les relations bidirectionnelles si nécessaire
        return organizer; // Retournez l'organisateur sans ses relations imbriquées
    }
}
