package ru.ilyam.messageboardengine.service;

import ru.ilyam.messageboardengine.dtos.message.CreateMessageDto;
import ru.ilyam.messageboardengine.dtos.message.TopicMessagesResponseDto;
import ru.ilyam.messageboardengine.dtos.topic.*;

public interface TopicService {
    void create(CreateTopicDto topicDto);

    void addMessage(Long topicId, Long userId, CreateMessageDto createMessageDto);

    TopicMessagesResponseDto findAllByTopicId(Long id);

    ReadTopicDto updateTopicName(UpdateTopicDto topicDto, Long id);

    TopicsResponseDto findAll();

    void delete(Long id);

}
