package org.paychex.mentorshipeducationproject.exceptions;

public class AlreadyEnrolledException extends RuntimeException {
    /**
     * This Exception is thrown when the user is already enrolled in the course or the mentorship
     */
    public AlreadyEnrolledException() {
        super();
    }
    public AlreadyEnrolledException(String message) {
        super(message);
    }
}
