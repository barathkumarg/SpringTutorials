package com.learn.SpringBootApplication.ErrorHandlings;

import com.learn.SpringBootApplication.Bean.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.LocalTime;

//Annotation used for the Exception and error handlings
@ControllerAdvice
public class CustomResponseEntityException extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> CustomAllExceptionHandler(Exception ex, WebRequest request) throws Exception{
        ErrorMessage errormessage = new ErrorMessage(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<ErrorMessage>(errormessage,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomResourceNotFoundException.class)
    public final ResponseEntity<ErrorMessage> CustomResourceNotFoundExceptionHandler(Exception ex, WebRequest request) throws Exception{
        ErrorMessage errormessage = new ErrorMessage(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity<ErrorMessage>(errormessage,HttpStatus.NOT_FOUND);

    }

    //custom exception to override the arguments check
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorMessage errormessage = new ErrorMessage(LocalDateTime.now(),
        "Total Errors:" + ex.getErrorCount() + " First Error:" + ex.getFieldError().getDefaultMessage(), request.getDescription(false));
        return new ResponseEntity(errormessage, HttpStatus.BAD_REQUEST);
    }


}
