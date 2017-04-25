package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by marc on 25/04/17.
 */
public class GalacticNumberExpressionUTest {


    //TODO: remove methods from GalacticNumberExpression type. They are not necessary as the
    // Expression knows how to resolve itself.


    //TODO: Rename method IExpression:calcualte() by resolve()

    @Test
    public void shouldCreateAMatchingExpression() throws ExpressionException {
        IExpression expression = new GalacticNumberExpression("glob is I");
        assertThat(expression.matches()).isTrue();
    }

    @Test
    public void shouldCreateANonMatchingExpression() throws ExpressionException {
        IExpression expression = new GalacticNumberExpression("not matching sentence here = I");
        assertThat(expression.matches()).isFalse();

        expression = new GalacticNumberExpression("glob is NONROMANNUM");
        assertThat(expression.matches()).isFalse();
    }


    @Test
    public void shouldRegisterTheGalacticNumberIntoTheCache() throws ExpressionException {

        IExpression expression = new GalacticNumberExpression("glob is I");

        expression.resolve(mocked_cache);

        //TODO: assert a galacticNumber is added to the cache.

    }



}
