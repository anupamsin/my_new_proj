package com.cybage.jpql_project.MessageResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CentralizedCustomResponse {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        map.put("Message : ", message);
        map.put("Status : ", status.value());
        map.put("Data : ", responseObj);
        return new ResponseEntity<>(map,status);
    }
}
