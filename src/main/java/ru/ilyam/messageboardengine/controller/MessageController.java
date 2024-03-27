package ru.ilyam.messageboardengine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ilyam.messageboardengine.dtos.message.ReadMessageDto;
import ru.ilyam.messageboardengine.service.MessageService;

@RestController
@RequestMapping("/api/v1/messages-management")
@AllArgsConstructor
@Tag(name="Сообщения", description="Управление записями сообщений")
public class MessageController {

    private final MessageService messageService;

    @Operation(
            summary = "Удаление сообщения по идентификатору"
    )
    @DeleteMapping("/message/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        messageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Получение списка сообщений"
    )
    @GetMapping("/messages")
    public ResponseEntity<Page<ReadMessageDto>> getAll(
            @RequestParam(value = "pageNumber", defaultValue = "0") @Min(0) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") @Min(1) Integer pageSize
    ) {
        return new ResponseEntity<>(messageService.getAll(PageRequest.of(pageNumber, pageSize)), HttpStatus.OK);
    }
}
