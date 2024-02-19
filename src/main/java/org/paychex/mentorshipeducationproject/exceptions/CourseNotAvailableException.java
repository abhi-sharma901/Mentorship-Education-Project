package org.paychex.mentorshipeducationproject.exceptions;

/**
 * This exception is thrown when course is not available, enrolled students are 100
 */
public class CourseNotAvailableException extends RuntimeException{
    public CourseNotAvailableException(){
        super();
    }
    public CourseNotAvailableException(String message){
        super(message);
    }
}
