package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.expressions.GalacticNumberExpression;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by andreufm on 07/04/2017.
 */
public class ExpressionRegistryUTest {

    private Set mocked_set;
    private ExpressionsRegistry expressionsRegistry;

    @Before
    public void setUp(){
        mocked_set = mock(Set.class);
        expressionsRegistry = new ExpressionsRegistry(mocked_set);
    }

    @Test
    public void shouldRegisterAnySubtypeOfIExpression(){
        Class sampleClass = GalacticNumberExpression.class;

        expressionsRegistry.registerExpression(sampleClass);

        verify(mocked_set).add(sampleClass);
    }


}
