package org.paychex.mentorshipeducationproject.exceptions;

/**
 * Exception thrown when the required record is not found in the database
 */
public class NoRecordFoundException extends RuntimeException{
    public NoRecordFoundException(){
        super();
    }
    public NoRecordFoundException(String msg){
        super(msg);
    }
}
