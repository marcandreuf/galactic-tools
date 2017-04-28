package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;
import com.marcandreuf.katas.domain.vo.GalacticCredit;
import com.marcandreuf.katas.domain.vo.GalacticNumber;
import org.junit.Before;
import org.junit.Test;

import static com.marcandreuf.katas.domain.vo.GalacticCredit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by marc on 26/04/17.
 */
public class GalacticCreditExpressionUTest {

    private GalacticCalculatorService mocked_calculator;
    private IExpression expression;

    @Before
    public void setUp(){
        mocked_calculator = mock(GalacticCalculatorService.class);
        expression = new GalacticCreditExpression("glob glob Silver is 34 Credits");
    }

    @Test
    public void shouldCreateAMatchingExpression() throws ExpressionException {
        assertThat(expression.matches()).isTrue();
    }

    @Test
    public void shouldCreateANonMatchingExpression() throws ExpressionException {
        IExpression expression = new GalacticNumberExpression("not matching sentence here = I");
        assertThat(expression.matches()).isFalse();
    }

    @Test
    public void shouldResolveAGalacticCreditExpression() throws ExpressionException, RomanNumberException {
        GalacticCredit galacticCredit = GalacticCreditBuilder.name("Silver").arabicValue(17).build();
        when(mocked_calculator.calcArabicValue(anyList())).thenReturn(2);

        String response = expression.resolve(mocked_calculator);

        assertThat(response).isEmpty();
        verify(mocked_calculator).register(eq(galacticCredit));
    }


    @Test
    public void shouldResolveAnEdgeCaseGalacticCreditExpression()
            throws Exception {
        GalacticCredit galacticCredit = GalacticCreditBuilder.name("Silver").arabicValue(0.5).build();
        when(mocked_calculator.calcArabicValue(anyList())).thenReturn(2);

        expression = new GalacticCreditExpression("glob glob Silver is 1 Credits");
        String response = expression.resolve(mocked_calculator);

        assertThat(response).isEmpty();
        verify(mocked_calculator).calcArabicValue(anyList());
        verify(mocked_calculator).register(eq(galacticCredit));
    }


    @Test
    public void shouldNotResolveAnExpressionIfGalacticNumbersAreNotDefined()
            throws Exception {
        when(mocked_calculator.calcArabicValue(anyList())).thenThrow(new RomanNumberException());

        assertThatExceptionOfType(ExpressionException.class)
                .isThrownBy(() ->  expression.resolve(mocked_calculator) );
        verify(mocked_calculator).calcArabicValue(anyList());
    }
}
