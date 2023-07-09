package com.progresssoft.clustereddatatask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {

    @ExceptionHandler(value = {BusinessException.class,
            DealAlreadyExists.class
    })
    public ResponseEntity<RestExceptionObject> handelExceptions(Exception exception){
        RestExceptionObject exceptionObject = new RestExceptionObject(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionObject,HttpStatus.BAD_REQUEST);
    }
}
