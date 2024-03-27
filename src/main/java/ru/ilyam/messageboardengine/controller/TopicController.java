package ru.ilyam.messageboardengine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ilyam.messageboardengine.dtos.message.CreateMessageDto;
import ru.ilyam.messageboardengine.dtos.message.TopicMessagesResponseDto;
import ru.ilyam.messageboardengine.dtos.topic.CreateTopicDto;
import ru.ilyam.messageboardengine.dtos.topic.ReadTopicDto;
import ru.ilyam.messageboardengine.dtos.topic.TopicsResponseDto;
import ru.ilyam.messageboardengine.dtos.topic.UpdateTopicDto;
import ru.ilyam.messageboardengine.service.TopicService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics-management")
@AllArgsConstructor
@Tag(name="Темы", description="Управление записями тем")
public class TopicController {
    private final TopicService topicService;

    @Operation(
            summary = "Создание новой темы"
    )
    @PostMapping("/topics/topic")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody CreateTopicDto createTopicDto) {
        topicService.create(createTopicDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(
            summary = "Получение списка всех тем"
    )
    @GetMapping("/topics")
    public ResponseEntity<Page<ReadTopicDto>> getAll(
            @RequestParam(value = "pageNumber", defaultValue = "0") @Min(0) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") @Min(1) Integer pageSize
    ) {
        return new ResponseEntity<>(topicService.findAll(PageRequest.of(pageNumber, pageSize)), HttpStatus.OK);
    }

    @Operation(
            summary = "Получение всех сообщений по данной теме"
    )
    @GetMapping("/topic/{topic_id}/messages")
    public ResponseEntity<TopicMessagesResponseDto> getAllTopicMessages(
            @PathVariable("topic_id") Long id) {
        return new ResponseEntity<>(topicService.findAllByTopicId(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Удаление темы по идентификатору",
            description = "Удаление темы и вместе с сообщениями, которые относятся к этой теме"
    )
    @DeleteMapping("/topic/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        topicService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Обновление названия темы"
    )
    @PutMapping("/topic/update/{id}")
    public ResponseEntity<ReadTopicDto> update(
            @PathVariable("id") Long id,
            @RequestBody UpdateTopicDto updateTopicDto
    ) {
        return new ResponseEntity<>(topicService.updateTopicName(updateTopicDto, id), HttpStatus.OK);
    }

    @Operation(
            summary = "Добавление нового сообщения в тему",
            description = "Добавление пользователем нового сообщения в тему"
    )
    @PostMapping("/topics/topic/{topic_id}/message/{user_id}")
    public ResponseEntity<HttpStatus> addMessage(
            @PathVariable("topic_id") Long topicId,
            @PathVariable("user_id") Long userId,
            @RequestBody CreateMessageDto createMessageDto) {
        topicService.addMessage(topicId, userId, createMessageDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
