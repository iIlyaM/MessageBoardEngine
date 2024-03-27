package ru.ilyam.messageboardengine.dtos.topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadTopicDto {
    private Long id;
    private String name;

    private String createdAt;

    private String updatedAt;
}
