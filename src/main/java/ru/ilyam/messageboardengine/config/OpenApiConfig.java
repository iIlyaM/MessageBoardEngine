package ru.ilyam.messageboardengine.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Message Board Engine Api",
                description = "Message Board Engine", version = "1.0.0",
                contact = @Contact(
                        name = "Moldavskiy Ilya",
                        email = "imoldavskiy@yandex.ru"
                )
        )
)
public class OpenApiConfig {

}