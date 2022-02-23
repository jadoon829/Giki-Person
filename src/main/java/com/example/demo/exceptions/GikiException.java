package com.example.demo.exceptions;

public abstract class GikiException extends Exception{

    public abstract ErrorCode getCode();
    public abstract String getDescription();
    public abstract Throwable getCause();
}
