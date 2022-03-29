package com.ctrlcutter.frontend.util.rest.exception;

public class JsonMappingException extends RuntimeException {

    public JsonMappingException(String exceptionString) {
        super(exceptionString);
    }

    public JsonMappingException(String exceptionString, Throwable exceptionThrowable) {
        super(exceptionString, exceptionThrowable);
    }
}
