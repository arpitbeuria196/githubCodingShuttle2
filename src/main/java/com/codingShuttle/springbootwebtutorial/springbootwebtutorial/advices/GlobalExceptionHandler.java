package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.advices;

import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.exceptions.ResourceNotFoundException;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNoSuchElementException(ResourceNotFoundException exception) {
       ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
       return  new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }




}

