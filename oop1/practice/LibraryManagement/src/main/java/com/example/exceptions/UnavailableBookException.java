package com.example.exceptions;

public class UnavailableBookException extends Exception {
    public UnavailableBookException(String exceptionMessage)
    {
        super(exceptionMessage);
    }
}
