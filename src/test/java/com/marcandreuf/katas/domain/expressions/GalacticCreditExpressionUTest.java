package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by marc on 26/04/17.
 */
public class GalacticCreditExpressionUTest {

    @Test
    public void shouldCreateAMatchingExpression() throws ExpressionException {
        IExpression expression = new GalacticCreditExpression("glob glob Silver is 34 Credits");
        assertThat(expression.matches()).isTrue();
    }

    @Test
    public void shouldCreateANonMatchingExpression() throws ExpressionException {
        IExpression expression = new GalacticNumberExpression("not matching sentence here = I");
        assertThat(expression.matches()).isFalse();
    }
}
