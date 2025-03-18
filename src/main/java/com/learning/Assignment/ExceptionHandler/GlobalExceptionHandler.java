package com.learning.Assignment.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
    //Handling the validation Exceptions.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> ValidationExceptionhandler(MethodArgumentNotValidException er) {
        
    	Map<String, String> errors = new HashMap<>(); // Defining the HashMap to store all the validation messages.

        er.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            
            String errorMessage = error.getDefaultMessage();
            
            errors.put(fieldName, errorMessage); //returning the exception messages.
        });

        return errors;
    }
    
    //Handling all other remaining exceptions.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String handlingRemainingExceptions(Exception er) {
        return er.getMessage();
    }
}
