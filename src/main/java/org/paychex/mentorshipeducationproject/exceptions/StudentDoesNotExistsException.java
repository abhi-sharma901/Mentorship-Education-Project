package org.paychex.mentorshipeducationproject.exceptions;

public class StudentDoesNotExistsException extends RuntimeException{
    private String message;

    public StudentDoesNotExistsException(){
        super();
    }
    public StudentDoesNotExistsException(String msg){
        super(msg);
        this.message = msg;
    }
}
