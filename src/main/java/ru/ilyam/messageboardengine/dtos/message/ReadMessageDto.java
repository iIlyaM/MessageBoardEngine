package ru.ilyam.messageboardengine.dtos.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность сообщение")
public class ReadMessageDto {
    private Long id;

    @Schema(description = "Текст сообщения", example = "Ресторан супер!")
    private String text;

    @Schema(description = "Псевдоним пользователя", example = "CoolGuy123")
    private String username;

    @Schema(description = "Дата создания сообщения")
    private String createdAt;

    @Schema(description = "Дата обновления сообщения")
    private String updatedAt;
}
