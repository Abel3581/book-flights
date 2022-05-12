package com.staff.flight.exception;

public class EmailAlreadyExistException extends Exception{

    private static final String EMAIL_ALREADY_EXIST_MESSAGE = "Email already exist.";

    private static final long serialVersionUID = 1L;

    public EmailAlreadyExistException() {
        super(EMAIL_ALREADY_EXIST_MESSAGE);
    }
}
