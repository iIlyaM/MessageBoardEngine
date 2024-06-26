package ru.ilyam.messageboardengine.dtos.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность Пользователь")
public class ReadUserDto {
    @Schema(description = "Идентификатор")
    private Long id;

    @Schema(description = "Электронная почта", example = "petroff@mail.com")
    private String email;

    @Schema(description = "Пароль", example = "g5f4gf46f4g")
    private String password;

    @Schema(description = "Псевдоним пользователя", example = "CoolGuy123")
    private String username;
}
