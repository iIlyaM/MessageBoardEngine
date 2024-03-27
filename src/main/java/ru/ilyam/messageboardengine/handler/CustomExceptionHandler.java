package ru.ilyam.messageboardengine.handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ilyam.messageboardengine.exception.AppCustomException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseBody
    @ExceptionHandler(AppCustomException.class)
    public ProblemDetail handleSecurityException(AppCustomException ex) {
        ProblemDetail errorDetail = ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(ex.getCode()), ex.getMessage());
        return errorDetail;
    }
}
