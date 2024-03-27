package ru.ilyam.messageboardengine.mapper;

import org.mapstruct.Mapper;
import ru.ilyam.messageboardengine.dtos.user.CreateUserDto;
import ru.ilyam.messageboardengine.dtos.user.ReadUserDto;
import ru.ilyam.messageboardengine.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserDto createUserDto);

    ReadUserDto toDto(User user);
}
