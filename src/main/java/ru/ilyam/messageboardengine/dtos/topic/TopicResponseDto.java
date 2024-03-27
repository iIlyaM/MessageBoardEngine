package ru.ilyam.messageboardengine.dtos.topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ilyam.messageboardengine.dtos.message.ReadMessageDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicResponseDto {
    private ReadTopicDto topicDto;
    private ReadMessageDto readMessageDto;
}
