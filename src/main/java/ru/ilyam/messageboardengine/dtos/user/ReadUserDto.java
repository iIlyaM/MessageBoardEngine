package ru.ilyam.messageboardengine.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadUserDto {
    private Long id;
    private String email;
    private String password;
    private String username;
}
