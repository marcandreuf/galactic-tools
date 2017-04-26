package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;

/**
 * Created by andreufm on 07/04/2017.
 *
 * This interface represents a generic expression. Any expression
 * needs to know how to resolve itself with the help of a given
 * cache that stores the state of the calculator.
 *
 */
public interface IExpression {

    boolean matches();
    String resolve(GalacticCalculatorService cache) throws ExpressionException;

}
