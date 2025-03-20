package ru.mental.disloc.deepimitationservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseBody<T>{

    private T data;
    private String message;
    private LocalDateTime timestamp;

    public ResponseBody(T data, String message) {
        this.data = data;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
