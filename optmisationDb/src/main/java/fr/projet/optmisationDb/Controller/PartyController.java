package fr.projet.optmisationDb.Controller;

import fr.projet.optmisationDb.DTO.PartyDTO;
import fr.projet.optmisationDb.Entity.Party;
import fr.projet.optmisationDb.Service.PartyService;
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
            @RequestParam(required = false, defaultValue = "PUBLIC") String partyType,
            @RequestParam(required = false, defaultValue = "false") Boolean isPaid,
            @RequestParam(required = false, defaultValue = "") String dateParty) {
        return partyService.getWithFilter(capacity, location, partyType, isPaid, dateParty);
    }
}
