package ru.ilyam.messageboardengine.dtos.topic;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Обновление записи темы")
public class UpdateTopicDto {
    @Schema(description = "Название темы", example = "Что думаете о новом итальянском ресторане?")
    private String name;
}