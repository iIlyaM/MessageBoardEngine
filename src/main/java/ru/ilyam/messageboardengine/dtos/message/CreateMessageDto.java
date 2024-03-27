package ru.ilyam.messageboardengine.dtos.message;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Создание сообщения")
public class CreateMessageDto {

    @NotBlank(message = "Сообщение не должно быть пустым")
    @Schema(description = "Текст сообщения", example = "Ресторан супер!")
    private String text;
}
