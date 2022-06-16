package com.example.springassignment3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle
{
    @ExceptionHandler
    public ResponseEntity<Response> handleException(PatientNotFoundException exc)
    {
        Response error = new Response(HttpStatus.NOT_FOUND.value(), exc.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Response> handleException(TestNotFoundException exc)
    {
        Response error = new Response(HttpStatus.NOT_FOUND.value(), exc.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Response> handleException(Exception exc)
    {
        Response error = new Response(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
