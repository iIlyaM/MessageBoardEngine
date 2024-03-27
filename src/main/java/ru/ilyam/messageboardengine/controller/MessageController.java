package ru.ilyam.messageboardengine.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilyam.messageboardengine.service.MessageService;

@RestController
@RequestMapping("/api/v1/messages-management")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @DeleteMapping("/message/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        messageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
