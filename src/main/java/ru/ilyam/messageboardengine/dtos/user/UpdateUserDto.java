package ru.ilyam.messageboardengine.dtos.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Обновление записи пользователя")
public class UpdateUserDto {
    @Schema(description = "Электронная почта", example = "petroff@mail.com")
    private String email;

    @Schema(description = "Пароль", example = "g5f4gf46f4g")
    private String password;

    @Schema(description = "Псевдоним", example = "CoolGuy123")
    private String username;
}
