package org.paychex.mentorshipeducationproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentDoesNotExistsException extends RuntimeException{
    public StudentDoesNotExistsException(){
        super();
    }
    public StudentDoesNotExistsException(String msg){
        super(msg);
    }
}
