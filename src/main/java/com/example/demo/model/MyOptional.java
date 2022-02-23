package com.example.demo.model;

import com.example.demo.exceptions.MyOptionalException;

import java.util.Optional;

public class MyOptional<P extends Person> {

    P value;

    public MyOptional(P value) {
        this.value = value;
    }

    public static MyOptional empty() {
        return new MyOptional<>(null);
    }

    public static <P extends Person> MyOptional<P> of(P value) {
        MyOptional myOptional = new MyOptional(value);
        return myOptional;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public P get() throws MyOptionalException {
        if (value == null) {
            throw new MyOptionalException("Tried to get null value");
//            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    public boolean isPresent() {
        return !isEmpty();
    }

    public static <P extends Person> MyOptional<P> toMyOptional(Optional<P> javaOptional) {

        return MyOptional.of(javaOptional.get());
    }

    @Override
    public String toString() {
        return  " " + value + ": ";
    }
}
