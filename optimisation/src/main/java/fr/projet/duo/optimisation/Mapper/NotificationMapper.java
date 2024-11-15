package fr.projet.duo.optimisation.Mapper;

import fr.projet.duo.optimisation.DTO.NotificationDTO;
import fr.projet.duo.optimisation.Entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    // Mapping pour éviter les références circulaires entre Notification et Users
    NotificationDTO toDTO(Notification notification);

    Notification toEntity(NotificationDTO notificationDTO);

    List<NotificationDTO> toDTOs(List<Notification> notifications);
    List<Notification> toEntities(List<NotificationDTO> notificationDTOs);
}
