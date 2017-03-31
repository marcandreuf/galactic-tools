package com.marcandreuf.katas.domain.exceptions;

/**
 * Created by andreufm on 31/03/2017.
 */
public class RomanNumberException extends Exception {
    public RomanNumberException() {
        super();
    }

    public RomanNumberException(String s) {
        super(s);
    }

    public RomanNumberException(String s, Throwable throwable) {
        super(s, throwable);
    }
}

