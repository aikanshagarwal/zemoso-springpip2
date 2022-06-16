package com.example.springassignment3.exception;

public class PatientNotFoundException extends RuntimeException
{
    public PatientNotFoundException(String message)
    {
        super(message);
    }

    public PatientNotFoundException(String message , Throwable cause)
    {
        super(message,cause);
    }

    public PatientNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
