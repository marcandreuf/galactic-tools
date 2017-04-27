package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;
import com.marcandreuf.katas.domain.vo.GalacticNumber;
import com.marcandreuf.katas.domain.vo.RomanNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

        expression = new GalacticNumberExpression("glob is NONROMANNUM");
        assertThat(expression.matches()).isTrue();
    }

    @Test
    public void shouldCreateANonMatchingExpression() throws ExpressionException {
        IExpression expression = new GalacticNumberExpression("not matching sentence here = I");
        assertThat(expression.matches()).isFalse();

    }


    @Test
    public void shouldResolveAMatchingExpression() throws ExpressionException {
        GalacticCalculatorService mocked_calculator = mock(GalacticCalculatorService.class);
        IExpression expression = new GalacticNumberExpression("glob is I");

        String response = expression.resolve(mocked_calculator);

        assertThat(response).isEmpty();
        verify(mocked_calculator).register(any(GalacticNumber.class));
    }


    @Test
    public void shouldNotBeAbleToResolveAMatchingExpression() throws ExpressionException {
        GalacticCalculatorService mocked_cache = mock(GalacticCalculatorService.class);
        IExpression expression = new GalacticNumberExpression("glob is NONROMANNUM");

        assertThatExceptionOfType(ExpressionException.class)
                .isThrownBy(() -> expression.resolve(mocked_cache))
                .withMessageContaining(RomanNumber.ERR_MSG_IS_NOT_A_VALID);
    }


}
