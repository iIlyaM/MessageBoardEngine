package ru.ilyam.messageboardengine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ilyam.messageboardengine.dtos.user.CreateUserDto;
import ru.ilyam.messageboardengine.dtos.user.ReadUserDto;
import ru.ilyam.messageboardengine.dtos.user.UpdateUserDto;
import ru.ilyam.messageboardengine.dtos.user.UsersResponseDto;
import ru.ilyam.messageboardengine.service.UserService;

@RestController
@RequestMapping("/api/v1/user-management")
@AllArgsConstructor
@Tag(name="Пользователи", description="Управление записями пользователей")
public class UserController {
    private final UserService userService;

    @Operation(
            summary = "Создание пользователя",
            description = "Позволяет создать нового пользователя"
    )
    @PostMapping("/users/user")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody CreateUserDto createUserDto) {
        userService.create(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(
            summary = "Получение списка пользователей",
            description = "Позволяет получить список всех пользователей системы"
    )
    @GetMapping("/users")
    public ResponseEntity<UsersResponseDto> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @Operation(
            summary = "Получение пользователя по идентификатору",
            description = "Позволяет получить пользователя по идентификатору"
    )
    @GetMapping("/user/{id}")
    public ResponseEntity<ReadUserDto> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Удаление пользователя по идентификатору"
    )
    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Обновление пользователя по идентификатору"
    )
    @PutMapping("/users/update/{id}")
    public ResponseEntity<ReadUserDto> update(
            @PathVariable("id") Long id,
            @RequestBody UpdateUserDto updateUserDto
    ) {
        return new ResponseEntity<>(userService.updateUser(id, updateUserDto), HttpStatus.OK);
    }
}
