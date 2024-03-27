package ru.ilyam.messageboardengine.controller;

import lombok.AllArgsConstructor;
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

@RestController
@RequestMapping("/api/v1/topics-management")
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping("/topics/topic")
    public ResponseEntity<HttpStatus> create(@RequestBody CreateTopicDto createTopicDto) {
        topicService.create(createTopicDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/topics")
    public ResponseEntity<TopicsResponseDto> getAll() {
        return new ResponseEntity<>(topicService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/topic/{topic_id}/messages")
    public ResponseEntity<TopicMessagesResponseDto> getAllTopicMessages(@PathVariable("topic_id") Long id) {
        return new ResponseEntity<>(topicService.findAllByTopicId(id), HttpStatus.OK);
    }

    @DeleteMapping("/topic/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        topicService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/topic/update/{id}")
    public ResponseEntity<ReadTopicDto> update(
            @PathVariable("id") Long id,
            @RequestBody UpdateTopicDto updateTopicDto
    ) {
        return new ResponseEntity<>(topicService.updateTopicName(updateTopicDto, id), HttpStatus.OK);
    }

    @PostMapping("/topics/topic/{topic_id}/message/{user_id}")
    public ResponseEntity<HttpStatus> addMessage(
            @PathVariable("topic_id") Long topicId,
            @PathVariable("user_id") Long userId,
            @RequestBody CreateMessageDto createMessageDto) {
        topicService.addMessage(topicId, userId, createMessageDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
