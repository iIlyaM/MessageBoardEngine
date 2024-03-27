package ru.ilyam.messageboardengine.dtos.topic;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ilyam.messageboardengine.dtos.message.CreateMessageDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Создание новой темы")
public class CreateTopicDto {
    @NotNull
    @Schema(description = "Идентификатор пользователь")
    private Long userId;

    @NotBlank(message = "Необходимо указать название темы")
    @Schema(description = "Название темы", example = "Что думаете о новом итальянском ресторане?")
    private String name;

    @NotNull(message = "Необходимо создать сообщение в теме")
    private CreateMessageDto message;
}
