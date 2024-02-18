package org.paychex.mentorshipeducationproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoRecordFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoRecordFoundException(NoRecordFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("No record found");
        return errorResponse;
    }

    @ExceptionHandler(TrainerNotAvailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleTrainerNotAvailableException(
            TrainerNotAvailableException ex
    ){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Trainer is not available");
        return errorResponse;
    }

    @ExceptionHandler(CourseNotAvailableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleCourseNotAvailableException(
        CourseNotAvailableException ex
    ){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Course is not available");
        return errorResponse;
    }

    @ExceptionHandler(PaymentMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePaymentMismatchException(
        PaymentMismatchException ex
    ){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Payment amount is not equal to the  cost");
        return errorResponse;
    }

    @ExceptionHandler(AlreadyEnrolledException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAlreadyEnrolledException(
        AlreadyEnrolledException ex
    ){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Already enrolled");
        return errorResponse;
    }
}
