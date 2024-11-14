package fr.projet.optmisationDb.Service;

import fr.projet.optmisationDb.DTO.PartyDTO;
import fr.projet.optmisationDb.Entity.PartyType;
import fr.projet.optmisationDb.Mapper.PartyMapper;
import fr.projet.optmisationDb.Repository.PartyRepository;
import fr.projet.optmisationDb.Repository.PartyTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {
    private final PartyRepository partyRepository;
    private final PartyTypeRepository partyTypeRepository;
    private final PartyMapper partyMapper;

    public PartyService(PartyRepository partyRepository, PartyTypeRepository partyTypeRepository, PartyMapper partyMapper) {
        this.partyRepository = partyRepository;
        this.partyTypeRepository = partyTypeRepository;
        this.partyMapper = partyMapper;
    }

    public List<PartyDTO> getWithFilter(Integer capacity, String location, String partyType, Boolean paid, String date_party) {
        PartyType partyTypeEntity = partyTypeRepository.findByName(partyType);
        System.out.println(partyTypeEntity);
        System.out.println(partyRepository.findByCapacityGreaterThanEqualAndLocationContainingAndPartyTypeAndIsPaidAndDatePartyContaining(capacity, location, partyTypeEntity, paid, date_party));
        return partyMapper.toDTOs(partyRepository.findByCapacityGreaterThanEqualAndLocationContainingAndPartyTypeAndIsPaidAndDatePartyContaining(capacity, location, partyTypeEntity, paid, date_party));
    }
}
