package com.haeseong.sirenorder.model.exception;

public class SignupFailureException extends RuntimeException {
    public SignupFailureException() {
    }

    public SignupFailureException(final String message) {
        super(message);
    }
}
