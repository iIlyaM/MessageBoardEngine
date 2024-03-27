package ru.ilyam.messageboardengine.dtos.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ilyam.messageboardengine.dtos.topic.ReadTopicDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicMessagesResponseDto {
    private ReadTopicDto topicDto;
    private MessagesResponseDto messagesResponseDto;
}
