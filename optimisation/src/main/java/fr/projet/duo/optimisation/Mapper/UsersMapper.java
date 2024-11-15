package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.UsersDTO;
import fr.projet.duo.optimisation.Entity.Users;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {InterestMapper.class})
public interface UsersMapper {

    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    @Mapping(target = "interests", ignore = true) // Ignorer pour éviter la récursion
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "party", ignore = true)
    @Mapping(target = "participationRequests", ignore = true)
    @Mapping(target = "organizedParties", ignore = true)
    UsersDTO userToUserDTO(Users users);

    @Mapping(target = "interests", ignore = true) // Ignorer pour éviter la récursion
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "party", ignore = true)
    @Mapping(target = "participationRequests", ignore = true)
    @Mapping(target = "organizedParties", ignore = true)
    List<UsersDTO> usersToUsersDTO(List<Users> users);

    @Mapping(target = "interests", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "party", ignore = true)
    @Mapping(target = "participationRequests", ignore = true)
    @Mapping(target = "organizedParties", ignore = true)
    Users UsersDTOToUsers(UsersDTO usersDTO);

    List<Users> UsersDTOToUsers(List<UsersDTO> usersDTO);

    Users UsersDTOToUsers(String organizer);
}
