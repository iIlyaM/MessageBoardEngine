package ru.ilyam.messageboardengine.dtos.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Создание пользователя")
public class CreateUserDto {
    @Email(message = "Email должен быть корректным адресом электронной почты")
    @Schema(description = "Электронная почта", example = "petroff@mail.com")
    private String email;

    @NotBlank(message = "Необходимо указать псевдоним")
    @Schema(description = "Пароль", example = "g5f4gf46f4g")
    private String password;

    @NotBlank(message = "Необходимо указать псевдоним")
    @Schema(description = "Псевдоним пользователя", example = "CoolGuy123")
    private String username;
}
