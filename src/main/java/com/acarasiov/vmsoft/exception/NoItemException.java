package com.acarasiov.vmsoft.exception;

public class NoItemException extends Exception{
    public NoItemException(String message) {
        super(message);
    }

    public NoItemException(String message, Throwable cause) {
        super(message, cause);
    }
}
