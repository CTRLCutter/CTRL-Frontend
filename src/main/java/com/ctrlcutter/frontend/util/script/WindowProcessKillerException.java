package com.ctrlcutter.frontend.util.script;

public class WindowProcessKillerException extends RuntimeException {

    public WindowProcessKillerException(String exceptionString) {
        super(exceptionString);
    }

    public WindowProcessKillerException(String exceptionString, Throwable exceptionThrowable) {
        super(exceptionString, exceptionThrowable);
    }
}
