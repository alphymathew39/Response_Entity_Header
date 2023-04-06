package com.example.Response_Entity_Header;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {


    @PostMapping("/A")
    public ResponseEntity<Map<String, String>> createUser(@RequestHeader(value = "Accept") String acceptHeader,
                                                          @RequestHeader(value = "Authorization") String authorizationHeader) {
        Map<String, String> returnValue = new HashMap<>();
        returnValue.put("Accept", acceptHeader);
        returnValue.put("Authorization", authorizationHeader);
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);

    }

    @PostMapping("/B")
    private String getUser(HttpServletRequest response) {
        return response.getHeader("Authorization");
    }
//key - Accept , value - application/json
//key -Authorization,  value - hiii
}