package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.expressions.GalacticNumberExpression;
import com.marcandreuf.katas.domain.expressions.IExpression;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by marc on 25/04/17.
 */
public class IReaderServiceUTest {


    private ExpressionsRegistry mocked_expressionRegistry;
    private IReaderService readerService;

    @Before
    public void setUp(){
        mocked_expressionRegistry = mock(ExpressionsRegistry.class);
        readerService = new ReaderService(mocked_expressionRegistry);

    }


    @Test
    public void shouldReadAGalacticNumberSentence(){
        String sampleSentence = "pish tegj glob glob is 42";

        IExpression expression =  readerService.read(sampleSentence);

        assertThat(expression).isInstanceOf(GalacticNumberExpression.class);
    }
}
