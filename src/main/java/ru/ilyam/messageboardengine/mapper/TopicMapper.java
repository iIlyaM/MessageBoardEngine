package ru.ilyam.messageboardengine.mapper;

import org.mapstruct.Mapper;
import ru.ilyam.messageboardengine.dtos.topic.ReadTopicDto;
import ru.ilyam.messageboardengine.entity.Topic;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    ReadTopicDto toDto(Topic topic);
}
