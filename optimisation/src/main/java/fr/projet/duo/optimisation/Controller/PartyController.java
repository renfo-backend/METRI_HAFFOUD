package fr.projet.duo.optimisation.Controller;
import fr.projet.duo.optimisation.DTO.PartyDTO;
import fr.projet.duo.optimisation.Entity.Request.BoardGamesPartyRequest;
import fr.projet.duo.optimisation.Entity.Request.ClassicPartyRequest;
import fr.projet.duo.optimisation.Entity.Request.LanPartyRequest;
import fr.projet.duo.optimisation.Service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {
    @Autowired
    private PartyService partyService;

    @GetMapping("/getWithFilter")
    public List<PartyDTO> getWithFilter(
            @RequestParam(required = false, defaultValue = "0") Integer capacity,
            @RequestParam(required = false, defaultValue = "") String location,
            @RequestParam(required = false, defaultValue = "") String partyType,
            @RequestParam(required = false) Boolean isPaid,
            @RequestParam(required = false, defaultValue = "") String dateParty) {
        return partyService.getWithFilter(capacity, location, partyType, isPaid, dateParty);
    }

    @GetMapping("/getAllPartyTypes")
    public List<PartyDTO> getAllPartyTypes() {
        return partyService.getAllPartyTypes();
    }

    @PostMapping("/addParty/boardgame")
    public PartyDTO addPartyBoardGame(@RequestBody BoardGamesPartyRequest boardGamesPartyRequest) {

        return partyService.addPartyBoardGame(boardGamesPartyRequest);
    }

    @PostMapping("/addParty/classic")
    public PartyDTO addPartyClassic(@RequestBody ClassicPartyRequest classicPartyRequest) {
        return partyService.addPartyClassic(classicPartyRequest);
    }

    @PostMapping("/addParty/lan")
    public PartyDTO addPartyLan(@RequestBody LanPartyRequest lanPartyRequest) {
        return partyService.addPartyLan(lanPartyRequest);
    }
}
