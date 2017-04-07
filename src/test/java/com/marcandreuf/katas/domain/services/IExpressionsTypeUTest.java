package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.GalacticNumberStatement;
import com.marcandreuf.katas.domain.IExpression;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by andreufm on 07/04/2017.
 */
public class IExpressionsTypeUTest {

    private ExpressionsRegistry expressionsRegistry;

    @Before
    public void setUp(){
        expressionsRegistry = new ExpressionsRegistry();
    }

    @Test
    public void shouldRegisterAnySubtypeOfIExpression(){
        expressionsRegistry.addExpressionType(GalacticNumberStatement.class);

        Set<Class<? extends IExpression>> expressions = expressionsRegistry.getExpressionTypes();
        assertThat(expressions).isNotEmpty();
    }


}
