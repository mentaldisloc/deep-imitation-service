package ru.mental.disloc.deepimitationservice.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mental.disloc.deepimitationservice.dto.ResponseBody;
import ru.mental.disloc.deepimitationservice.pojo.User;

import java.io.DataInput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoadController {

    private Map<String, User> users = new HashMap<>();

    @Operation(
            summary = "UserCreation",
            description = "This method imitate the application workload to the server",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User was created.", content = {
                            @Content(mediaType = "application/json")
                    }),
                    @ApiResponse(responseCode = "400", description = "User already exist or data incorrect.", content = {
                            @Content(mediaType = "application/json")
                    }),
                    @ApiResponse(responseCode = "500", description = "Server error. Application fall down.", content = {
                            @Content(mediaType = "application/json")
                    })
            })
    @PostMapping(value = "/workload", consumes = "application/json")
    public ResponseEntity<ResponseBody> createUser(@RequestBody User json) {
        ResponseBody response = new ResponseBody("jopa");
        users.put(response.getUuid(), json);
        return ResponseEntity.status(200).body(response);
    }
}