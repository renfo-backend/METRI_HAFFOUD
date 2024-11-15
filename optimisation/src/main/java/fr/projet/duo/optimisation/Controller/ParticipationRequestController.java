package fr.projet.duo.optimisation.Controller;

import fr.projet.duo.optimisation.DTO.ParticipationRequestDTO;
import fr.projet.duo.optimisation.Service.ParticipationRequestService;
import fr.projet.duo.optimisation.Util.JwtUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participationRequest")
public class ParticipationRequestController {

    @Autowired
    private ParticipationRequestService participationRequestService;

    @PostMapping("/createParticipationRequest")
    public ResponseEntity<String> createParticipationRequest(
            @RequestParam Long idParty,
            @RequestHeader("Authorization") String authorizationHeader) {

        // Extraire le token sans le préfixe "Bearer "

        return ResponseEntity.ok(participationRequestService.createParticipationRequest(authorizationHeader, idParty));

    }

    @PutMapping("/changeStatusParticipationRequest")
    public ResponseEntity<String> changeStatusParticipationRequest(
            @RequestParam Long idParticipationRequest,
            @RequestParam String status,
            @RequestHeader("Authorization") String authorizationHeader) {


        return ResponseEntity.ok(participationRequestService.changeStatusParticipationRequest(authorizationHeader, idParticipationRequest, status));

    }



}
