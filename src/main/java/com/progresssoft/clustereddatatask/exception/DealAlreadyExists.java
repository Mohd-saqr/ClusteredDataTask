package com.progresssoft.clustereddatatask.exception;

public class DealAlreadyExists extends RuntimeException{

    public DealAlreadyExists() {
    }

    public DealAlreadyExists(String message) {
        super(message);
    }
}
