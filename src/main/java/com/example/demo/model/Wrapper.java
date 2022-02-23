package com.example.demo.model;

import java.util.Optional;

public class Wrapper<T extends Person> {
    T value;

    Wrapper(T value) {
        this.value = value;
    }

    public static <P extends Person>  Wrapper<P> of(P javaOptional ){
        Wrapper wrapper = new Wrapper(javaOptional);
        return wrapper;
    }

    public T get() {
        if(value == null) {
            value = null;
        }
        return value;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public boolean isPresent() {
        return !isEmpty();
    }

    public static < T extends Person > Wrapper<T> from(Optional<T> javaOpt) {
        return Wrapper.of(javaOpt.get());
    }
}
