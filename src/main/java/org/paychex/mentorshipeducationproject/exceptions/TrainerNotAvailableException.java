package org.paychex.mentorshipeducationproject.exceptions;

/**
 * Exception thrown when The trainer is already doing a course or mentorship
 */
public class TrainerNotAvailableException extends RuntimeException {
    public TrainerNotAvailableException() {
        super();
    }
    public TrainerNotAvailableException(String message) {
        super(message);
    }
}
