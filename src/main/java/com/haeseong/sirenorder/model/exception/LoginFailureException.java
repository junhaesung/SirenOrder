package com.haeseong.sirenorder.model.exception;

public class LoginFailureException extends RuntimeException {
    public LoginFailureException() {
    }

    public LoginFailureException(String message) {
        super(message);
    }
}
