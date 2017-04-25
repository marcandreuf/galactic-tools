package com.marcandreuf.katas.domain.exceptions;

/**
 * Created by andreufm on 31/03/2017.
 */
public class ExpressionException extends Exception {
    public ExpressionException() {
        super();
    }

    public ExpressionException(String s) {
        super(s);
    }

    public ExpressionException(String s, Throwable throwable) {
        super(s, throwable);
    }
}

