package ru.ilyam.messageboardengine.mapper;

import org.springframework.stereotype.Component;
import ru.ilyam.messageboardengine.dtos.message.ReadMessageDto;
import ru.ilyam.messageboardengine.entity.Message;

@Component
public class CustomMessageMapperImpl implements CustomMessageMapper {

    public ReadMessageDto toDto(Message message) {
        return new ReadMessageDto(
                message.getId(),
                message.getText(),
                message.getUser().getUsername(),
                message.getCreatedAt().toString(),
                message.getUpdatedAt().toString()
        );
    }
}
