package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.expressions.IExpression;

/**
 * Created by marc on 25/04/17.
 */
public interface IReaderService {
    IExpression read(String sentence) throws ExpressionException;
}
