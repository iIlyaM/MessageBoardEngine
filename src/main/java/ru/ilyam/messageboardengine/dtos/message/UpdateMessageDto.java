package ru.ilyam.messageboardengine.dtos.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Обновление записи сообщения")
public class UpdateMessageDto {
    @Schema(description = "Текст сообщения", example = "Ресторан супер!")
    private String text;
}