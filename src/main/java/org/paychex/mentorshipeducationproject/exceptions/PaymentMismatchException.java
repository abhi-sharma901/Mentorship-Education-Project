package org.paychex.mentorshipeducationproject.exceptions;

public class PaymentMismatchException extends RuntimeException{
    public PaymentMismatchException() {
        super();
    }
    public PaymentMismatchException(String message) {
        super(message);
    }
}
