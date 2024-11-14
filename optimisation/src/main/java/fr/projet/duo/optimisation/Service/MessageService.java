package fr.projet.duo.optimisation.Service;

import fr.projet.duo.optimisation.DTO.MessageDTO;
import fr.projet.duo.optimisation.Mapper.MessageMapper;
import fr.projet.duo.optimisation.Repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageDTO> getAllMessages() {
        System.out.println(messageRepository.findAll());
        return MessageMapper.INSTANCE.toDTOs(messageRepository.findAll());

    }
}
