package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.expressions.IExpression;

import java.util.Set;

/**
 * Created by marc on 25/04/17.
 */
public class ReaderService implements IReaderService {

    public static final String SENTENCE_NOT_MATCHING = "I have no idea what you are talking about";
    private final ExpressionsRegistry expressionRegistry;

    public ReaderService(ExpressionsRegistry expressionRegistry) {
        this.expressionRegistry = expressionRegistry;
    }

    @Override
    public IExpression read(String sentence) throws ExpressionException {
        Set<Class<? extends IExpression>> registeredExpressions = expressionRegistry.getExpressionTypes();

        for(Class expressionType : registeredExpressions){
            try {
                IExpression expression = (IExpression) expressionType.getDeclaredConstructor(String.class).newInstance(sentence);
                if(expression.matches()){
                    return expression;
                }
            } catch (Exception e) {
                throw new ExpressionException(e.getMessage(), e);
            }
        }
        throw new ExpressionException(SENTENCE_NOT_MATCHING);
    }
}
