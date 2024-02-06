package com.java.vishnu.DemoProject.ApplicationExceptionHandle;

import com.java.vishnu.DemoProject.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandlerClass {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleInvalidArgument(UserNotFoundException ex) {
        Map<String,String> errorHandler = new HashMap<>();
        errorHandler.put("INTERNAL-SERVER-ERROR",ex.getMessage());
        return errorHandler;
    }
}
