package ru.ilyam.messageboardengine.mapper;

import org.mapstruct.Mapper;
import ru.ilyam.messageboardengine.dtos.message.ReadMessageDto;
import ru.ilyam.messageboardengine.entity.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    ReadMessageDto toDto(Message message);
}
