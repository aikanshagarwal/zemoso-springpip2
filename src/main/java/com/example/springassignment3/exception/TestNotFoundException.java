package com.example.springassignment3.exception;


public class TestNotFoundException extends RuntimeException
{
    public TestNotFoundException(String message)
    {
        super(message);
    }

    public TestNotFoundException(String message,Throwable cause)
    {
        super(message,cause);
    }

    public TestNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
