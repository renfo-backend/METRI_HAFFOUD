package fr.projet.duo.optimisation.Controller;

import fr.projet.duo.optimisation.DTO.MessageDTO;
import fr.projet.duo.optimisation.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<MessageDTO> getAllMessages() {
        return messageService.getAllMessages();
    }
}
