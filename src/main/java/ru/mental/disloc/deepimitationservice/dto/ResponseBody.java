package ru.mental.disloc.deepimitationservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ResponseBody{

    private String uuid;
    private String message;
    private LocalDateTime timestamp;

    public ResponseBody(String message) {
        this.uuid = UUID.randomUUID().toString();
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
