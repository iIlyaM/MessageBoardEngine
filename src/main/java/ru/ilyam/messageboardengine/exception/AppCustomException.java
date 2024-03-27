package ru.ilyam.messageboardengine.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppCustomException extends RuntimeException {
    private Integer code;
    private String message;
}
