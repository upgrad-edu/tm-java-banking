package com.upGrad.exceptions;

public class AccountDetailsNotFoundException extends Exception {
    public AccountDetailsNotFoundException() {
    }

    public AccountDetailsNotFoundException(String message) {
        super(message);
    }

    public AccountDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    public AccountDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
