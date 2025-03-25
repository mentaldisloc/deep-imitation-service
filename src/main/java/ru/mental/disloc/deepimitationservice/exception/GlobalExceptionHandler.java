package ru.mental.disloc.deepimitationservice.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.mental.disloc.deepimitationservice.dto.ResponseBody;

@ControllerAdvice("ru.mental.disloc.deepimitationservice")
public class GlobalExceptionHandler {

    @Operation(
            summary = "handleJsonParseException",
            description = "This method handle exceptions of invalid JSON-files format",
            responses = {
                    @ApiResponse(responseCode = "400", description = "Invalid JSON format", content = {
                            @Content(mediaType = "application/json")
                    })
            }
    )
    @ExceptionHandler({JsonParseException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ResponseBody> handleJsonParseException(Exception e) {

        ResponseBody response = new ResponseBody("Invalid JSON format: " + e.getMessage());
        return ResponseEntity.status(400).body(response);
    }

    @Operation(
            summary = "handleJsonMappingException",
            description = "This method handle errors of mapping JSON-files to object",
            responses = {
                    @ApiResponse(responseCode = "400", description = "Error mapping JSON to object", content = {
                            @Content(mediaType = "application/json")
                    })
            }
    )
    @ExceptionHandler({JsonMappingException.class, JsonProcessingException.class})
    public ResponseEntity<ResponseBody> handleJsonMappingException(JsonMappingException e) {

        ResponseBody response = new ResponseBody("Error mapping JSON to object: " + e.getMessage());
        return ResponseEntity.status(400).body(response);
    }

    @Operation(
            summary = "handleIllegalArgumentException",
            description = "This method handle error of  none-JSON-files format",
            responses = {
                    @ApiResponse(responseCode = "400", description = "Invalid argument", content = {
                            @Content(mediaType = "application/json")
                    })
            }
    )
    @ExceptionHandler({IllegalArgumentException.class, HttpMediaTypeNotSupportedException.class})
    public ResponseEntity<ResponseBody> handleIllegalArgumentException(Exception e) {

        if (e instanceof IllegalArgumentException) {
            ResponseBody response = new ResponseBody("Invalid argument: " + e.getMessage());
            return ResponseEntity.status(400).body(response);
        } else {
            ResponseBody response = new ResponseBody("Unsupported media type: " + e.getMessage());
            return ResponseEntity.status(415).body(response);
        }
    }

    @Operation(
            summary = "handleRuntimeException",
            description = "This method handle errors of program at all",
            responses = {
                    @ApiResponse(responseCode = "500", description = "Error mapping JSON to object", content = {
                            @Content(mediaType = "application/json")
                    })
            }
    )
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseBody> handleRuntimeException(Exception e) {

        ResponseBody response = new ResponseBody("Internal server error: " + e.getMessage());
        return ResponseEntity.status(500).body(response);
    }
}
