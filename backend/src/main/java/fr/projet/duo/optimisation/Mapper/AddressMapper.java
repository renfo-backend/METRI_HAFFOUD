package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.AddressDTO;
import fr.projet.duo.optimisation.Entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressDTO dto);
    AddressDTO toDTO(Address entity);
}
