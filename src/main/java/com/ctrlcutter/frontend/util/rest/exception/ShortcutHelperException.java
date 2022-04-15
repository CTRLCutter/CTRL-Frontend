package com.ctrlcutter.frontend.util.rest.exception;

public class ShortcutHelperException extends RuntimeException {

    public ShortcutHelperException(String exceptionString) {
        super(exceptionString);
    }

    public ShortcutHelperException(String exceptionString, Throwable exceptionThrowable) {
        super(exceptionString, exceptionThrowable);
    }
}
