package ru.ilyam.messageboardengine.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ilyam.messageboardengine.dtos.message.CreateMessageDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewTopicDto {
    private String name;
    private CreateMessageDto message;
}
