package ru.ilyam.messageboardengine.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ilyam.messageboardengine.dtos.user.CreateUserDto;
import ru.ilyam.messageboardengine.dtos.user.ReadUserDto;
import ru.ilyam.messageboardengine.dtos.user.UsersResponseDto;
import ru.ilyam.messageboardengine.service.UserService;

@RestController
@RequestMapping("/api/v1/user-management")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users/user")
    public ResponseEntity<HttpStatus> create(@RequestBody CreateUserDto createUserDto) {
        userService.create(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<UsersResponseDto> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ReadUserDto> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<ReadUserDto> update(
            @PathVariable("id") Long id,
            @RequestBody CreateUserDto createUserDto
    ) {
        return new ResponseEntity<>(userService.updateUser(id, createUserDto), HttpStatus.OK);
    }
}
