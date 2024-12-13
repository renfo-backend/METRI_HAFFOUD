package fr.projet.duo.optimisation.Service;

import fr.projet.duo.optimisation.DTO.PartyDTO;
import fr.projet.duo.optimisation.Entity.*;
import fr.projet.duo.optimisation.Entity.Request.BoardGamesPartyRequest;
import fr.projet.duo.optimisation.Entity.Request.ClassicPartyRequest;
import fr.projet.duo.optimisation.Entity.Request.LanPartyRequest;
import fr.projet.duo.optimisation.Mapper.*;
import fr.projet.duo.optimisation.Repository.*;
import fr.projet.duo.optimisation.Util.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;


    public PartyService(PartyRepository partyRepository, UsersRepository usersRepository, PartyTypeRepository partyTypeRepository, BoardGamesPartyTypeRepository boardGamesPartyTypeRepository, PartyMapper partyMapper, UsersMapper usersMapper, BoardGamesPartyDetailsMapper boardGamesPartyDetailsMapper, ClassicPartyTypeRepository classicPartyTypeRepository, ClassicPartyDetailsMapper classicPartyDetailsMapper, LANPartyTypeRepository lanPartyTypeRepository, LanPartyDetailsMapper lanPartyDetailsMapper, AddressRepository addressRepository, AddressMapper addressMapper) {
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
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
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



    public List<PartyDTO> getWithFilter(Integer capacity, String location, String partyType, Boolean paid, String dateParty, String token) {
        Users users=usersRepository.findByUsername(JwtUtil.extractUsername(token)).get();
        System.out.println(partyRepository.findPartiesWithOptionalPaymentFilter(capacity, location, paid, dateParty, partyType,users));
        return partyMapper.toDTOs(partyRepository.findPartiesWithOptionalPaymentFilter(capacity,location,paid,dateParty,partyType,users));
    }

    public List<PartyDTO> getAllPartyTypes() {
        return partyMapper.toDTOs(partyRepository.findAll());
    }

    public PartyDTO addPartyBoardGame(BoardGamesPartyRequest boardGamesPartyRequest, String token) {
        Users organizer=usersRepository.findByUsername(JwtUtil.extractUsername(token)).get();
        boardGamesPartyRequest.getParty().setAddress(addressMapper.toDTO(addressRepository.save(addressMapper.toEntity(boardGamesPartyRequest.getParty().getAddress()))));

        // Ensuite, sauvegarder le type de soirée
        System.out.println(boardGamesPartyRequest.getBoardGamesDetails());
        BoardGamesPartyType boardGamesDetails = boardGamesPartyDetailsMapper.toDTO(boardGamesPartyRequest.getBoardGamesDetails());
        System.out.println(boardGamesDetails);
        BoardGamesPartyType savedBoardGamesDetails = boardGamesPartyTypeRepository.save(boardGamesDetails); // Assurez-vous que ce repository est injecté

        // Assigner l'organisateur sauvegardé et le type de soirée à la party
        Party party = partyMapper.toEntity(boardGamesPartyRequest.getParty());
        party.setOrganizer(organizer);
        party.setPartyType(savedBoardGamesDetails);
        party.getPartyType().setDescription(boardGamesPartyRequest.getBoardGamesDetails().getDescription());
        party.getPartyType().setName("BOARDGAMES");

        // Sauvegarder la party
        Party savedParty = partyRepository.save(party);

        // Retourner le DTO de la party sauvegardée
        return partyMapper.toDTO(savedParty);
    }

    public PartyDTO addPartyClassic(ClassicPartyRequest classicPartyRequest,String token) {
        // Sauvegarder l'organisateur d'abord
        Users organizer=usersRepository.findByUsername(JwtUtil.extractUsername(token)).get();
        classicPartyRequest.getParty().setAddress(addressMapper.toDTO(addressRepository.save(addressMapper.toEntity(classicPartyRequest.getParty().getAddress()))));
        // Ensuite, sauvegarder le type de soirée
        ClassicPartyType classicPartyType = classicPartyDetailsMapper.toDTO(classicPartyRequest.getClassicDetails());
        ClassicPartyType classicPartyType1 = classicPartyTypeRepository.save(classicPartyType); // Assurez-vous que ce repository est injecté

        // Assigner l'organisateur sauvegardé et le type de soirée à la party
        Party party = partyMapper.toEntity(classicPartyRequest.getParty());
        party.setOrganizer(organizer);
        party.setPartyType(classicPartyType1);
        party.getPartyType().setDescription(classicPartyRequest.getClassicDetails().getDescription());
        party.getPartyType().setName("CLASSIC");
        // Sauvegarder la party
        Party savedParty = partyRepository.save(party);

        // Retourner le DTO de la party sauvegardée
        return partyMapper.toDTO(savedParty);
    }

    public PartyDTO addPartyLan(LanPartyRequest lanPartyRequest, String token) {
        // Sauvegarder l'organisateur d'abord
        Users organizer=usersRepository.findByUsername(JwtUtil.extractUsername(token)).get();
        lanPartyRequest.getParty().setAddress(addressMapper.toDTO(addressRepository.save(addressMapper.toEntity(lanPartyRequest.getParty().getAddress()))));

        LANPartyType lanPartyType = lanPartyDetailsMapper.toEntity(lanPartyRequest.getLanDetails());
        LANPartyType lanPartyType1 = lanPartyTypeRepository.save(lanPartyType); // Assurez-vous que ce repository est injecté

        // Assigner l'organisateur sauvegardé et le type de soirée à la party
        Party party = partyMapper.toEntity(lanPartyRequest.getParty());
        party.setPartyType(lanPartyType1);
        party.getPartyType().setDescription(lanPartyRequest.getLanDetails().getDescription());
        party.getPartyType().setName("LAN");
        party.setOrganizer(organizer);

        Party savedParty = partyRepository.save(party);

        return partyMapper.toDTO(savedParty);

    }

    public List<PartyDTO> getAllPartiesUserIsOrganizer(String token) {
        Users organizer = usersRepository.findByUsername(JwtUtil.extractUsername(token)).get();
        return partyMapper.toDTOs(partyRepository.findByOrganizerId(organizer.getId()));
    }

    public List<PartyDTO> getAllPartiesUserIsNotOrganizer(String token) {
        Users user = usersRepository.findByUsername(JwtUtil.extractUsername(token)).get();
        return partyMapper.toDTOs(partyRepository.findAllParties(user));
    }

    public void deleteParty(Long partyId) {
        partyRepository.deleteById(partyId);
    }

    public PartyDTO updateParty(Long id, PartyDTO partyDTO, String token) {
        Long userId = JwtUtil.extractUserId(token);

        Party existingParty = partyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Party not found"));

        // Vérifiez si userId est bien l’organisateur de la party
        if (!existingParty.getOrganizer().getId().equals(userId)) {
            throw new AccessDeniedException("Vous n'avez pas le droit de modifier cette soirée.");
        }


        // Mettre à jour les propriétés
        existingParty.setName(partyDTO.getName());
        existingParty.setDateParty(partyDTO.getDateParty());
        existingParty.setCapacity(partyDTO.getCapacity());
        existingParty.setPrice(partyDTO.getPrice());

        Party savedParty = partyRepository.save(existingParty);

        return partyMapper.toDTO(savedParty);
    }

    public PartyDTO getPartyById(Long id, String token) {
        // Extraire l'userId du token si nécessaire
        Long userId = JwtUtil.extractUserId(token);

        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Party not found"));

        System.out.println("party = " + party);
        // Ici, vous pouvez ajouter des vérifications par rapport à l'utilisateur
        // Par exemple, vérifier que l'utilisateur courant a le droit de voir cette party
        // si nécessaire. Sinon, vous pouvez directement retourner la party.

        return partyMapper.toDTO(party);
    }

    public List<PartyDTO> getUpcomingParties(String token) {
        Long userId = JwtUtil.extractUserId(token);

        // Récupérer les parties dont l'utilisateur a une participationRequest non rejetée et date >= aujourd'hui
        List<Party> parties = partyRepository.findUpcomingPartiesByUserId(userId);
        return parties.stream().map(partyMapper::toDTO).collect(Collectors.toList());
    }

}
