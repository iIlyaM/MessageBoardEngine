package ru.ilyam.messageboardengine.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersResponseDto {
    private List<ReadUserDto> users;
}