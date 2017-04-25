package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.expressions.GalacticNumberExpression;
import com.marcandreuf.katas.domain.expressions.IExpression;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by marc on 25/04/17.
 *
 */
public class IReaderServiceITest {

    private ExpressionsRegistry expressionRegistry;
    private IReaderService readerService;

    @Before
    public void setUp(){
        expressionRegistry = new ExpressionsRegistry(new HashSet<>());
        expressionRegistry.registerExpression(GalacticNumberExpression.class);
        readerService = new ReaderService(expressionRegistry);
    }

    @Test
    public void shouldReadAGalacticNumberSentence() throws ExpressionException {
        IExpression expression =  readerService.read("glob is I");
        assertThat(expression).isInstanceOf(GalacticNumberExpression.class);
    }

    @Test
    public void shouldThrowAnExceptionForNonMatchingSentences() throws ExpressionException {
        assertThatExceptionOfType(ExpressionException.class)
                .isThrownBy(() -> readerService.read("Some non matching sentence here."))
                .withMessage(ReaderService.SENTENCE_NOT_MATCHING);
    }

}
