package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.IExpression;

import java.util.Set;

/**
 * Created by andreufm on 07/04/2017.
 */
public class ExpressionsRegistry {

    private final Set<Class<? extends IExpression>> expressionTypes;

    public ExpressionsRegistry(Set<Class<? extends IExpression>> expressionTypes) {
        this.expressionTypes = expressionTypes;
    }


    public void addExpressionType(Class<? extends IExpression> cls){
        expressionTypes.add(cls);
    }


    public Set<Class<? extends IExpression>> getExpressionTypes() {
        return expressionTypes;
    }
}
