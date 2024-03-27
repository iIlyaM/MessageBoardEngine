package ru.ilyam.messageboardengine.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ilyam.messageboardengine.dtos.message.CreateMessageDto;
import ru.ilyam.messageboardengine.dtos.message.MessagesResponseDto;
import ru.ilyam.messageboardengine.dtos.message.ReadMessageDto;
import ru.ilyam.messageboardengine.dtos.message.UpdateMessageDto;
import ru.ilyam.messageboardengine.entity.Message;
import ru.ilyam.messageboardengine.entity.Topic;
import ru.ilyam.messageboardengine.entity.User;
import ru.ilyam.messageboardengine.mapper.CustomMessageMapper;
import ru.ilyam.messageboardengine.repository.MessageRepository;
import ru.ilyam.messageboardengine.repository.UserRepository;
import ru.ilyam.messageboardengine.service.MessageService;
import ru.ilyam.messageboardengine.utils.ServicesUtils;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    private final CustomMessageMapper messageMapper;
    private final UserRepository userRepository;

    @Override
    public Message create(CreateMessageDto messageDto, Topic topic, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();

        Message message = new Message();
        message.setText(messageDto.getText());
        message.setCreatedAt(LocalDateTime.now());
        message.setUpdatedAt(LocalDateTime.now());
        message.setUser(user);
        message.setTopic(topic);
        user.setMessages(Set.of(message));
        return messageRepository.save(message);
    }

    @Override
    public MessagesResponseDto getAll() {
        return new MessagesResponseDto(
                messageRepository.findAll().stream()
                        .map(messageMapper::toDto)
                        .toList());
    }

    @Override
    public ReadMessageDto findById(Long id) {
        return messageMapper.toDto(messageRepository.findById(id).orElseThrow());
    }

    @Override
    public MessagesResponseDto findAllByTopicId(Long id) {
        return new MessagesResponseDto(
                messageRepository.findAllByTopicId(id).stream()
                        .map(messageMapper::toDto)
                        .toList());
    }

    @Override
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }


    @Override
    public ReadMessageDto updateMessage(Long messageId, UpdateMessageDto requestDto) {
        var msg = messageRepository.findById(messageId).orElseThrow();
        if (ServicesUtils.ifFieldUpdate(requestDto.getText())) {
            msg.setText(requestDto.getText());
            msg.setUpdatedAt(LocalDateTime.now());
        }
        return messageMapper.toDto(msg);
    }
}
