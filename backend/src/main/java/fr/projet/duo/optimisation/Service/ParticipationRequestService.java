package fr.projet.duo.optimisation.Service;

import fr.projet.duo.optimisation.DTO.ParticipationRequestDTO;
import fr.projet.duo.optimisation.Entity.ParticipationRequest;
import fr.projet.duo.optimisation.Entity.Users;
import fr.projet.duo.optimisation.Mapper.ParticipationRequestMapper;
import fr.projet.duo.optimisation.Repository.ParticipationRequestRepository;
import fr.projet.duo.optimisation.Repository.PartyRepository;
import fr.projet.duo.optimisation.Repository.UsersRepository;
import fr.projet.duo.optimisation.Util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationRequestService {

    private final ParticipationRequestRepository participationRequestRepository;
    private final PartyRepository partyRepository;

    private final UsersRepository usersRepository;

    private final ParticipationRequestMapper participationRequestMapper;

    public ParticipationRequestService(ParticipationRequestRepository participationRequestRepository, PartyRepository partyRepository, UsersRepository usersRepository, ParticipationRequestMapper participationRequestMapper) {
        this.participationRequestRepository = participationRequestRepository;
        this.partyRepository = partyRepository;
        this.usersRepository = usersRepository;
        this.participationRequestMapper = participationRequestMapper;
    }

    public String createParticipationRequest(String authorizationHeader, Long idParty) {
        String token;
        if (authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7); // Supprimer le "Bearer " pour ne conserver que le token
        } else {
            throw new IllegalArgumentException("Invalid Authorization header");
        }

        String userId = JwtUtil.extractUsername(token);

        ParticipationRequest participationRequest = new ParticipationRequest();
        participationRequest.setUsers(usersRepository.findByUsername(userId).get());
        System.out.println(usersRepository.findByUsername(userId).get());
        participationRequest.setParty(partyRepository.findById(idParty).get());
        participationRequest.setStatus("PENDING");

        System.out.println(participationRequestRepository.save(participationRequest));


        if (participationRequestMapper.toDTO(participationRequestRepository.save(participationRequest)).getId() != null) {
            return "Participation request created";
        } else {
            return "Participation request not created";
        }
    }

    public String changeStatusParticipationRequest(String authorizationHeader, Long idParticipationRequest, String status) {
        String token;
        if (authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7); // Supprimer le "Bearer " pour ne conserver que le token
        } else {
            throw new IllegalArgumentException("Invalid Authorization header");
        }

        Long userId = JwtUtil.extractUserId(token);

        ParticipationRequest participationRequest = participationRequestRepository.findById(idParticipationRequest).get();
        if (participationRequest.getParty().getOrganizer().getId().equals(userId)) {
            System.out.println("dedans ");
            participationRequest.setStatus(status);
            participationRequestRepository.save(participationRequest);
            return "Status changed";
        } else {
            return "Status not changed";
        }
    }

    public List<ParticipationRequestDTO> getParticipationRequest(String token) {
        Users users = usersRepository.findByUsername(JwtUtil.extractUsername(token)).get();
        return participationRequestMapper.toDTOs(participationRequestRepository.findByUsers(users));
    }
}
