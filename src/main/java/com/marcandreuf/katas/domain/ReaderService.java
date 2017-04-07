package com.marcandreuf.katas.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreufm on 07/04/2017.
 */
public class ReaderService {

    private final List<Class<? extends IExpression>> expressionTypes = new ArrayList<>();

    public void addExpressionType(Class<? extends IExpression> cls){
        expressionTypes.add(cls);
    }

}
