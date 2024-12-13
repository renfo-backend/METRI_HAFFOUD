package fr.projet.duo.optimisation.Controller;
import fr.projet.duo.optimisation.DTO.PartyDTO;
import fr.projet.duo.optimisation.Entity.Request.BoardGamesPartyRequest;
import fr.projet.duo.optimisation.Entity.Request.ClassicPartyRequest;
import fr.projet.duo.optimisation.Entity.Request.LanPartyRequest;
import fr.projet.duo.optimisation.Service.PartyService;
import fr.projet.duo.optimisation.Util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {
    @Autowired
    private PartyService partyService;

    @GetMapping("/{id}")
    public ResponseEntity<PartyDTO> getPartyById(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {
        System.out.println("test");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        String token = authorizationHeader.substring(7).trim();
        System.out.println("token = " + token);
        PartyDTO partyDTO = partyService.getPartyById(id, token);
        return ResponseEntity.ok(partyDTO);
    }


    @GetMapping("/getAllPartiesWithFilter")
    public List<PartyDTO> getWithFilter(
            @RequestParam(required = false, defaultValue = "0") Integer capacity,
            @RequestParam(required = false, defaultValue = "") String location,
            @RequestParam(required = false, defaultValue = "") String partyType,
            @RequestParam(required = false) Boolean isPaid,
            @RequestParam(required = false, defaultValue = "") String dateParty,
            @RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        String token = authorizationHeader.substring(7).trim();


        return partyService.getWithFilter(capacity, location, partyType, isPaid, dateParty, token);
    }

    @GetMapping("/getAllPartyTypes")
    public List<PartyDTO> getAllPartyTypes() {
        return partyService.getAllPartyTypes();
    }

    @PostMapping("/addParty/boardgame")
    public PartyDTO addPartyBoardGame(@RequestBody BoardGamesPartyRequest boardGamesPartyRequest, @RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        String token = authorizationHeader.substring(7).trim();

        System.out.println(boardGamesPartyRequest);
        return partyService.addPartyBoardGame(boardGamesPartyRequest, token);
    }


    @PostMapping("/addParty/classic")
    public PartyDTO addPartyClassic(@RequestBody ClassicPartyRequest classicPartyRequest, @RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        System.out.println("authorizationHeader = " + authorizationHeader);

        String token = authorizationHeader.substring(7).trim();

        return partyService.addPartyClassic(classicPartyRequest,token);
    }

    @PostMapping("/addParty/lan")
    public PartyDTO addPartyLan(@RequestBody LanPartyRequest lanPartyRequest, @RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        String token = authorizationHeader.substring(7).trim();

        return partyService.addPartyLan(lanPartyRequest,token);
    }

    @GetMapping("/getPartyByOrganizer")
    public List<PartyDTO> getPartyByOrganizer(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }



        String token = authorizationHeader.substring(7).trim();


        return partyService.getAllPartiesUserIsOrganizer(token);
    }

    @DeleteMapping("/deleteParty/{id}")
    public ResponseEntity<Void> deleteParty(@PathVariable Long id, @RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        String token = authorizationHeader.substring(7).trim();
        // Appelez votre service pour supprimer la party
        partyService.deleteParty(id);

        // Retourne une réponse "No Content" pour indiquer la réussite sans contenu
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateParty/{id}")
    public ResponseEntity<PartyDTO> updateParty(
            @PathVariable Long id,
            @RequestBody PartyDTO partyDTO,
            @RequestHeader("Authorization") String authorizationHeader) {

        // Vérification du token si nécessaire
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        String token = authorizationHeader.substring(7).trim();

        // Appel du service pour mettre à jour la party
        PartyDTO updatedParty = partyService.updateParty(id, partyDTO, token);

        return ResponseEntity.ok(updatedParty);
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<PartyDTO>> getUpcomingParties(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Authorization header format");
        }

        String token = authorizationHeader.substring(7).trim();
        List<PartyDTO> upcomingParties = partyService.getUpcomingParties(token);
        return ResponseEntity.ok(upcomingParties);
    }


//    @GetMapping("/getAllParties")
//    public List<PartyDTO> getAllParties(@RequestHeader("Authorization") String authorizationHeader) {
//        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
//            throw new IllegalArgumentException("Invalid Authorization header format");
//        }
//
//        String token = authorizationHeader.substring(7).trim();
//
//        return partyService.getAllPartiesUserIsNotOrganizer(token);
//    }

}
