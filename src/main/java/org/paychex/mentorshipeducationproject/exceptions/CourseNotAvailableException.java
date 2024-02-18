package org.paychex.mentorshipeducationproject.exceptions;

public class CourseNotAvailableException extends RuntimeException{
    public CourseNotAvailableException(){
        super();
    }
    public CourseNotAvailableException(String message){
        super(message);
    }
}
