package org.paychex.mentorshipeducationproject.exceptions;

public class TrainerNotAvailableException extends RuntimeException {
    public TrainerNotAvailableException() {
        super();
    }
    public TrainerNotAvailableException(String message) {
        super(message);
    }
}
