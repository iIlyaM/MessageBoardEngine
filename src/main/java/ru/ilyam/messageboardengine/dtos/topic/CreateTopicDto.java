package ru.ilyam.messageboardengine.dtos.topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ilyam.messageboardengine.dtos.message.CreateMessageDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTopicDto {
    private Long userId;
    private String name;
    private CreateMessageDto message;
}
