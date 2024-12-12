package fr.projet.duo.optimisation.Controller;

import fr.projet.duo.optimisation.DTO.ParticipationRequestDTO;
import fr.projet.duo.optimisation.Entity.Request.ChangeStatusRequest;
import fr.projet.duo.optimisation.Service.ParticipationRequestService;
import fr.projet.duo.optimisation.Util.JwtUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/changeStatusParticipationRequest")
    public ResponseEntity<String> changeStatusParticipationRequest(
            @RequestBody ChangeStatusRequest changeStatusRequest,
            @RequestHeader("Authorization") String authorizationHeader) {


        return ResponseEntity.ok(participationRequestService.changeStatusParticipationRequest(authorizationHeader, changeStatusRequest.getId(), changeStatusRequest.getStatus()));

    }

    @GetMapping("/getParticipationRequest")
    public List<ParticipationRequestDTO> getParticipationRequest(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestParam(value = "id") Long id) {
        System.out.println("getParticipationRequest"+id);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        String token = authorizationHeader.substring(7).trim();


        return participationRequestService.getParticipationRequest(token,id);

    }


    @GetMapping("/getParticipationRequestInvite")
    public List<ParticipationRequestDTO> getParticipationRequestInvite(
            @RequestHeader("Authorization") String authorizationHeader) {

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        String token = authorizationHeader.substring(7).trim();
        return participationRequestService.getParticipationRequestInvite(token);
    }
}
