package ru.ilyam.messageboardengine.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.ilyam.messageboardengine.dtos.message.CreateMessageDto;
import ru.ilyam.messageboardengine.dtos.message.TopicMessagesResponseDto;
import ru.ilyam.messageboardengine.dtos.topic.*;

import java.util.List;

public interface TopicService {
    void create(CreateTopicDto topicDto);

    void addMessage(Long topicId, Long userId, CreateMessageDto createMessageDto);

    TopicMessagesResponseDto findAllByTopicId(Long id);

    ReadTopicDto updateTopicName(UpdateTopicDto topicDto, Long id);

    Page<ReadTopicDto> findAll(Pageable pageable);

    void delete(Long id);

}
