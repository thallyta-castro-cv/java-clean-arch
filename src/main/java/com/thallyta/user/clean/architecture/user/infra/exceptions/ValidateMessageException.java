package com.thallyta.user.clean.architecture.user.infra.exceptions;

public class ValidateMessageException extends RuntimeException{

    public ValidateMessageException(String message) {
        super(message);
    }
}
