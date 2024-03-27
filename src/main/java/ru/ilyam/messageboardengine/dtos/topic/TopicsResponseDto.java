package ru.ilyam.messageboardengine.dtos.topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicsResponseDto {
    private List<ReadTopicDto> topics;
}
