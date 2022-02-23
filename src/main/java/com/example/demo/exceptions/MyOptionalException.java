package com.example.demo.exceptions;

public class MyOptionalException extends GikiException {
    private String description;
    public MyOptionalException(String description){
        this.description = description;
    }
    @Override
    public ErrorCode getCode() {
        return ErrorCode.E_MYOPTIONAL;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Throwable getCause() {
        return null;
    }

}
