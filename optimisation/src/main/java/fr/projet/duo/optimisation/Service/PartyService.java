package fr.projet.duo.optimisation.Service;

import fr.projet.duo.optimisation.DTO.PartyDTO;
import fr.projet.duo.optimisation.Entity.*;
import fr.projet.duo.optimisation.Entity.Request.BoardGamesPartyRequest;
import fr.projet.duo.optimisation.Entity.Request.ClassicPartyRequest;
import fr.projet.duo.optimisation.Entity.Request.LanPartyRequest;
import fr.projet.duo.optimisation.Mapper.*;
import fr.projet.duo.optimisation.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {
    private final PartyRepository partyRepository;
    private final UsersRepository usersRepository;
    private final PartyTypeRepository partyTypeRepository;

    private final BoardGamesPartyTypeRepository boardGamesPartyTypeRepository;
    private final PartyMapper partyMapper;
    private final UsersMapper usersMapper;
    private final BoardGamesPartyDetailsMapper boardGamesPartyDetailsMapper;

    private final ClassicPartyTypeRepository classicPartyTypeRepository;

    private final ClassicPartyDetailsMapper classicPartyDetailsMapper;

    private final LANPartyTypeRepository lanPartyTypeRepository;
    private final LanPartyDetailsMapper lanPartyDetailsMapper;


    public PartyService(PartyRepository partyRepository, UsersRepository usersRepository, PartyTypeRepository partyTypeRepository, BoardGamesPartyTypeRepository boardGamesPartyTypeRepository, PartyMapper partyMapper, UsersMapper usersMapper, BoardGamesPartyDetailsMapper boardGamesPartyDetailsMapper, ClassicPartyTypeRepository classicPartyTypeRepository, ClassicPartyDetailsMapper classicPartyDetailsMapper, LANPartyTypeRepository lanPartyTypeRepository, LanPartyDetailsMapper lanPartyDetailsMapper) {
        this.partyRepository = partyRepository;
        this.usersRepository = usersRepository;
        this.partyTypeRepository = partyTypeRepository;
        this.boardGamesPartyTypeRepository = boardGamesPartyTypeRepository;
        this.partyMapper = partyMapper;
        this.usersMapper = usersMapper;
        this.boardGamesPartyDetailsMapper = boardGamesPartyDetailsMapper;
        this.classicPartyTypeRepository = classicPartyTypeRepository;
        this.classicPartyDetailsMapper = classicPartyDetailsMapper;
        this.lanPartyTypeRepository = lanPartyTypeRepository;
        this.lanPartyDetailsMapper = lanPartyDetailsMapper;
    }

    public PartyDTO createParty(PartyDTO partyDTO) {
        // Vérifier que l'organisateur existe
        Users organizer = usersRepository.findById(partyDTO.getOrganizer().getId())
                .orElseThrow(() -> new RuntimeException("Organisateur non trouvé"));

        // Mapper PartyDTO vers une entité Party
        Party party = partyMapper.toEntity(partyDTO);

        // Associer l'organisateur
        party.setOrganizer(organizer);

        // Gérer le type de fête
        if (partyDTO.getPartyType() != null) {
            PartyType partyType = partyTypeRepository.findById(partyDTO.getPartyType().getId())
                    .orElseThrow(() -> new RuntimeException("Type de fête non trouvé"));
            party.setPartyType(partyType);
        }

        // Sauvegarder la party
        Party savedParty = partyRepository.save(party);

        // Retourner le DTO correspondant
        return partyMapper.toDTO(savedParty);
    }



    public List<PartyDTO> getWithFilter(Integer capacity, String location, String partyType, Boolean paid, String date_party) {
        System.out.println(partyRepository.findPartiesWithOptionalPaymentFilter(capacity, location, paid, date_party, partyType));
        return partyMapper.toDTOs(partyRepository.findPartiesWithOptionalPaymentFilter(capacity,location,paid,date_party,partyType));
    }

    public List<PartyDTO> getAllPartyTypes() {
        return partyMapper.toDTOs(partyRepository.findAll());
    }

    public PartyDTO addPartyBoardGame(BoardGamesPartyRequest boardGamesPartyRequest) {
        // Sauvegarder l'organisateur d'abord
        Users organizer = usersMapper.UsersDTOToUsers(boardGamesPartyRequest.getParty().getOrganizer());
        Users savedOrganizer = usersRepository.save(organizer);  // Assurez-vous que usersRepository est injecté dans le service

        // Ensuite, sauvegarder le type de soirée
        BoardGamesPartyType boardGamesDetails = boardGamesPartyDetailsMapper.toDTO(boardGamesPartyRequest.getBoardGamesDetails());
        BoardGamesPartyType savedBoardGamesDetails = boardGamesPartyTypeRepository.save(boardGamesDetails); // Assurez-vous que ce repository est injecté

        // Assigner l'organisateur sauvegardé et le type de soirée à la party
        Party party = partyMapper.toEntity(boardGamesPartyRequest.getParty());
        party.setOrganizer(savedOrganizer);
        party.setPartyType(savedBoardGamesDetails);

        // Sauvegarder la party
        Party savedParty = partyRepository.save(party);

        // Retourner le DTO de la party sauvegardée
        return partyMapper.toDTO(savedParty);
    }

    public PartyDTO addPartyClassic(ClassicPartyRequest classicPartyRequest) {
        // Sauvegarder l'organisateur d'abord
        Users organizer = usersMapper.UsersDTOToUsers(classicPartyRequest.getParty().getOrganizer());
        Users savedOrganizer = usersRepository.save(organizer);  // Assurez-vous que usersRepository est injecté dans le service

        // Ensuite, sauvegarder le type de soirée
        ClassicPartyType classicPartyType = classicPartyDetailsMapper.toDTO(classicPartyRequest.getClassicDetails());
        ClassicPartyType classicPartyType1 = classicPartyTypeRepository.save(classicPartyType); // Assurez-vous que ce repository est injecté

        // Assigner l'organisateur sauvegardé et le type de soirée à la party
        Party party = partyMapper.toEntity(classicPartyRequest.getParty());
        party.setOrganizer(savedOrganizer);
        party.setPartyType(classicPartyType1);

        // Sauvegarder la party
        Party savedParty = partyRepository.save(party);

        // Retourner le DTO de la party sauvegardée
        return partyMapper.toDTO(savedParty);
    }

    public PartyDTO addPartyLan(LanPartyRequest lanPartyRequest) {
        // Sauvegarder l'organisateur d'abord
        Users organizer = usersMapper.UsersDTOToUsers(lanPartyRequest.getParty().getOrganizer());
        Users savedOrganizer = usersRepository.save(organizer);  // Assurez-vous que usersRepository est injecté dans le service

        // Ensuite, sauvegarder le type de soirée
        LANPartyType lanPartyType = lanPartyDetailsMapper.toEntity(lanPartyRequest.getLanDetails());
        LANPartyType lanPartyType1 = lanPartyTypeRepository.save(lanPartyType); // Assurez-vous que ce repository est injecté

        // Assigner l'organisateur sauvegardé et le type de soirée à la party
        Party party = partyMapper.toEntity(lanPartyRequest.getParty());
        party.setOrganizer(savedOrganizer);
        party.setPartyType(lanPartyType1);

        // Sauvegarder la party
        Party savedParty = partyRepository.save(party);

        // Retourner le DTO de la party sauvegardée
        return partyMapper.toDTO(savedParty);

    }

}
