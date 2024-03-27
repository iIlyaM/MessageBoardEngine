package ru.ilyam.messageboardengine.dtos.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ilyam.messageboardengine.dtos.topic.ReadTopicDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicMessagesResponseDto {
    private Long id;
    private String name;
    private String createdAt;
    private String updatedAt;
    private List<ReadMessageDto> messages;
}
