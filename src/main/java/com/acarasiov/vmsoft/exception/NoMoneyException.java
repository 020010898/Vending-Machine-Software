package com.acarasiov.vmsoft.exception;

public class NoMoneyException extends Exception{
    public NoMoneyException(String message) {
        super(message);
    }

    public NoMoneyException(String message, Throwable cause) {
        super(message, cause);
    }
}
