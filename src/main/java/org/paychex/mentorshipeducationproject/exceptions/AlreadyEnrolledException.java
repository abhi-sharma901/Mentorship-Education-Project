package org.paychex.mentorshipeducationproject.exceptions;

public class AlreadyEnrolledException extends RuntimeException {

    public AlreadyEnrolledException() {
        super();
    }
    public AlreadyEnrolledException(String message) {
        super(message);
    }
}
