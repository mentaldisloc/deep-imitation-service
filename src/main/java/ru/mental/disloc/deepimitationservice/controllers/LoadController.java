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
import ru.mental.disloc.deepimitationservice.pojo.User;

import java.io.DataInput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workload")
@Tag(
        name = "Workload imitation",
        description = "This controller imitate the application workload to the server"
)
public class LoadController {

    private Map<String, User> users = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();

    @Operation(
            summary = "UserCreation",
            description = "Simple workload that creating named objects",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User was created", content = {
                            @Content(mediaType = "application/json")
                    }),
                    @ApiResponse(responseCode = "400", description = "User already exist", content = {
                            @Content(mediaType = "application/json")
                    })
            })
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody String json) {
        try {
            User user = mapper.readValue(json, User.class);

            if (users.containsKey(user.getName())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            users.put(user.getName(), user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (JsonParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (JsonMappingException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}