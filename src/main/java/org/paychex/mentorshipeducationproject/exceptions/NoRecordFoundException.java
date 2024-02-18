package org.paychex.mentorshipeducationproject.exceptions;


public class NoRecordFoundException extends RuntimeException{
    public NoRecordFoundException(){
        super();
    }
    public NoRecordFoundException(String msg){
        super(msg);
    }
}
