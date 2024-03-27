package ru.ilyam.messageboardengine.mapper;

import ru.ilyam.messageboardengine.dtos.message.ReadMessageDto;
import ru.ilyam.messageboardengine.entity.Message;

public interface CustomMessageMapper {
    ReadMessageDto toDto(Message message);
}
