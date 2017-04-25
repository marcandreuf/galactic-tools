package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.expressions.IExpression;

import java.util.Set;

/**
 * Created by marc on 25/04/17.
 */
public class ReaderService implements IReaderService {


    private final ExpressionsRegistry expressionRegistry;

    public ReaderService(ExpressionsRegistry expressionRegistry) {
        this.expressionRegistry = expressionRegistry;
    }

    @Override
    public IExpression read(String sentence) throws IllegalAccessException, InstantiationException {

        Set<Class<? extends IExpression>> registeredExpressions = expressionRegistry.getExpressionTypes();

        for(Class type : registeredExpressions){
            IExpression expression = (IExpression) type.newInstance();
            //TODO: new instance with paramter String to send sentence by constructor.
            if(expression.matches()){
                return expression;
            }

        }


        return null;
    }
}
