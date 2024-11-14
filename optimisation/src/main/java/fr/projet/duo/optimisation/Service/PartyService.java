package fr.projet.duo.optimisation.Service;

import fr.projet.duo.optimisation.CycleAvoidingMappingContext;
import fr.projet.duo.optimisation.DTO.PartyDTO;
import fr.projet.duo.optimisation.Mapper.PartyMapper;
import fr.projet.duo.optimisation.Repository.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {
    private final PartyRepository partyRepository;
    private final PartyMapper partyMapper;


    public PartyService(PartyRepository partyRepository, PartyMapper partyMapper) {
        this.partyRepository = partyRepository;
        this.partyMapper = partyMapper;
    }


    public List<PartyDTO> getWithFilter(Integer capacity, String location, String partyType, Boolean paid, String date_party) {
        System.out.println(partyRepository.findPartyByCapacityGreaterThanEqualAndLocationContaining(capacity, location));
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        PartyDTO partyDTO=partyMapper.toDTOs(partyRepository.findPartyByCapacityGreaterThanEqualAndLocationContaining(capacity, location),context).get(0);
        System.out.println(partyDTO);
//        System.out.println(partyMapper.INSTANCE.toDTOs(partyRepository.findByCapacityGreaterThanEqualAndLocationContainingAndPartyTypeAndIsPaidAndDatePartyContaining(capacity, location, partyType, paid, date_party)));
        return partyMapper.toDTOs(partyRepository.findPartyByCapacityGreaterThanEqualAndLocationContaining(capacity,location),context);
    }
}
