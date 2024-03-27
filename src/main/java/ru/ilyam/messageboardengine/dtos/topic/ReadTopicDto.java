package ru.ilyam.messageboardengine.dtos.topic;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность Тема")
public class ReadTopicDto {
    @Schema(description = "Идентификатор темы")
    private Long id;

    @Schema(description = "Название темы", example = "Что думаете о новом итальянском ресторане?")
    private String name;

    @Schema(description = "Дата создания темы")
    private String createdAt;

    @Schema(description = "Дата обновления темы")
    private String updatedAt;
}
