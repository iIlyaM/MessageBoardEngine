package ru.ilyam.messageboardengine.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.ilyam.messageboardengine.dtos.message.CreateMessageDto;
import ru.ilyam.messageboardengine.dtos.message.TopicMessagesResponseDto;
import ru.ilyam.messageboardengine.dtos.topic.CreateTopicDto;
import ru.ilyam.messageboardengine.dtos.topic.ReadTopicDto;
import ru.ilyam.messageboardengine.dtos.topic.UpdateTopicDto;
import ru.ilyam.messageboardengine.entity.Topic;
import ru.ilyam.messageboardengine.entity.User;
import ru.ilyam.messageboardengine.exception.AppCustomException;
import ru.ilyam.messageboardengine.mapper.CustomMessageMapper;
import ru.ilyam.messageboardengine.mapper.TopicMapper;
import ru.ilyam.messageboardengine.repository.MessageRepository;
import ru.ilyam.messageboardengine.repository.TopicRepository;
import ru.ilyam.messageboardengine.repository.UserRepository;
import ru.ilyam.messageboardengine.service.MessageService;
import ru.ilyam.messageboardengine.service.TopicService;
import ru.ilyam.messageboardengine.utils.ServicesUtils;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    private final MessageRepository messageRepository;
    private final MessageService messageService;
    private final TopicMapper topicMapper;

    private final CustomMessageMapper messageMapper;


    @Override
    @Transactional
    public void create(CreateTopicDto topicDto) {
        User user = userRepository.findById(topicDto.getUserId()).orElseThrow(
                () -> new AppCustomException(404, "Пользователь не был найден"));

        Topic topic = new Topic();
        topic.setName(topicDto.getName());
        topic.setCreatedAt(LocalDateTime.now());
        topic.setUpdatedAt(LocalDateTime.now());
        topic.setUser(user);

        var addedTopic = topicRepository.save(topic);
        addMessage(addedTopic.getId(), topicDto.getUserId(), topicDto.getMessage());
    }

    @Override
    public void addMessage(Long topicId, Long userId, CreateMessageDto createMessageDto) {
        var topic = topicRepository.findById(topicId).orElseThrow(
                () -> new AppCustomException(404, "Тема не была найдена"));

        var message = messageService.create(createMessageDto, topic, userId);
        message.setTopic(topic);
        topicRepository.save(topic);
    }


    @Override
    public TopicMessagesResponseDto findAllByTopicId(Long id) {
        var topic = topicRepository.findById(id).orElseThrow(
                () -> new AppCustomException(404, "Тема не была найдена")
        );
        return new TopicMessagesResponseDto(
                topic.getId(),
                topic.getName(),
                topic.getCreatedAt().toString(),
                topic.getUpdatedAt().toString(),
                messageRepository.findAllByTopicId(id).stream().map(messageMapper::toDto).toList());
    }

    @Override
    public ReadTopicDto updateTopicName(UpdateTopicDto topicDto, Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow(
                () -> new AppCustomException(404, "Тема не была найдена")
        );
        if (ServicesUtils.ifFieldUpdate(topicDto.getName())) {
            topic.setName(topicDto.getName());
            topic.setUpdatedAt(LocalDateTime.now());
        }
        return topicMapper.toDto(topicRepository.save(topic));
    }

    @Override
    public Page<ReadTopicDto> findAll(Pageable pageable) {
        return topicRepository.findAll(pageable)
                .map(topicMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        topicRepository.deleteById(id);
    }


}
