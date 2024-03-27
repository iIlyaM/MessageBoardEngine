package ru.ilyam.messageboardengine.dtos.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadMessageDto {
    private Long id;

    private String text;

    private String username;

    private String createdAt;

    private String updatedAt;
}
