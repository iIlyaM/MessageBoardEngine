package ru.ilyam.messageboardengine.service;

import ru.ilyam.messageboardengine.dtos.user.CreateUserDto;
import ru.ilyam.messageboardengine.dtos.user.ReadUserDto;
import ru.ilyam.messageboardengine.dtos.user.UsersResponseDto;

public interface UserService {
    void create(CreateUserDto user);

    UsersResponseDto getAll();

    ReadUserDto findById(Long id);

    void delete(Long id);

    ReadUserDto updateUser(Long userId, CreateUserDto requestDto);
}
