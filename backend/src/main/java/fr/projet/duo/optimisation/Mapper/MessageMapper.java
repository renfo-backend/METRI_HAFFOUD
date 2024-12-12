package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.MessageDTO;
import fr.projet.duo.optimisation.Entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsersMapper.class, PartyMapper.class})
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    @Mapping(target = "users.notifications", ignore = true) // Ignorer les notifications dans Users pour éviter la récursion
    @Mapping(target = "users.party", ignore = true)
//    @Mapping(target = "users.participationRequests", ignore = true)
    @Mapping(target = "users.organizedParties", ignore = true)
    @Mapping(target = "users.interests", ignore = true)
    @Mapping(target = "party.messages", ignore = true) // Ignorer les messages dans Party pour éviter la récursion
    @Mapping(target = "party.participant", ignore = true)
    @Mapping(target = "party.participationRequests", ignore = true)
    @Mapping(target = "party.organizer", ignore = true)
    MessageDTO toDTO(Message message);

    List<MessageDTO> toDTOs(List<Message> messages);

    @Mapping(target = "users.notifications", ignore = true)
    @Mapping(target = "users.party", ignore = true)
//    @Mapping(target = "users.participationRequests", ignore = true)
    @Mapping(target = "users.organizedParties", ignore = true)
    @Mapping(target = "users.interests", ignore = true)
    @Mapping(target = "party.messages", ignore = true)
    @Mapping(target = "party.participant", ignore = true)
    @Mapping(target = "party.participationRequests", ignore = true)
    @Mapping(target = "party.organizer", ignore = true)
    Message toEntity(MessageDTO messageDTO);

    List<Message> toEntities(List<MessageDTO> messageDTOs);
}
