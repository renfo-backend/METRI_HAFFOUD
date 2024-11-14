package fr.projet.optmisationDb.Service;

import fr.projet.optmisationDb.DTO.PartyDTO;
import fr.projet.optmisationDb.Mapper.PartyMapper;
import fr.projet.optmisationDb.Repository.PartyRepository;
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
        return partyMapper.toDTOs(partyRepository.findPartyByCapacityGreaterThanEqualAndLocationContaining(capacity, location));
    }
}
