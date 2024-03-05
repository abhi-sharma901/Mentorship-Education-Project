package org.paychex.mentorshipeducationproject.exceptions;

/**
 * This is Thrown when the payment amount is not equal to the cost
 * either installment or full amount
 */
public class PaymentMismatchException extends RuntimeException{
    public PaymentMismatchException() {
        super();
    }
    public PaymentMismatchException(String message) {
        super(message);
    }
}
