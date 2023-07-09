package com.progresssoft.clustereddatatask.exception;

public class BusinessException extends RuntimeException{

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
