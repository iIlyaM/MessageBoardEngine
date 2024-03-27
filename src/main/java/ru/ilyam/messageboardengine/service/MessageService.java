package ru.ilyam.messageboardengine.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.ilyam.messageboardengine.dtos.message.CreateMessageDto;
import ru.ilyam.messageboardengine.dtos.message.MessagesResponseDto;
import ru.ilyam.messageboardengine.dtos.message.ReadMessageDto;
import ru.ilyam.messageboardengine.dtos.message.UpdateMessageDto;
import ru.ilyam.messageboardengine.entity.Message;
import ru.ilyam.messageboardengine.entity.Topic;


public interface MessageService {

    Message create(CreateMessageDto message, Topic topic, Long userId);

    Page<ReadMessageDto> getAll(Pageable pageable);

    ReadMessageDto findById(Long id);

    MessagesResponseDto findAllByTopicId(Long id);

    void delete(Long id);

    ReadMessageDto updateMessage(Long messageId, UpdateMessageDto updateMessageDto);
}
