package ru.ilyam.messageboardengine.dtos.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessagesResponseDto {
    private List<ReadMessageDto> messages;
}
