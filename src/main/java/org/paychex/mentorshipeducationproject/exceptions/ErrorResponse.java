package org.paychex.mentorshipeducationproject.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Getter
//@Setter
//@RequiredArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class ErrorResponse {
//    private final int status;
//    private final String message;
//    private String stackTrace;
//    private List<ValidationError> errors;
//    @Getter
//    @Setter
//    @RequiredArgsConstructor
//    public static class ValidationError{
//        private final String field;
//        private final String message;
//    }
//
//    public void addValidationError(String field, String message){
//        if(Objects.isNull(errors)){
//            errors = new ArrayList<>();
//        }
//        errors.add(new ValidationError(field, message));
//    }
//}

/**
 * Class to structure the error response
 */
@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {
    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
