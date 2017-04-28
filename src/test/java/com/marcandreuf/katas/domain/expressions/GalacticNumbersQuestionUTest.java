package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;
import com.marcandreuf.katas.domain.vo.GalacticNumber;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by marc on 28/04/17.
 */
public class GalacticNumbersQuestionUTest {

    private IExpression matchingExpression;
    private IExpression nonMatchingExpression;
    private GalacticCalculatorService mocked_calculator;

    @Before
    public void setUp(){
        matchingExpression = new GalacticNumbersQuestion("how much is pish tegj glob glob ?");
        nonMatchingExpression = new GalacticNumbersQuestion("not matching question here ");
        mocked_calculator = mock(GalacticCalculatorService.class);
    }

    @Test
    public void shouldCreateAMatchingExpression() throws ExpressionException {
        assertThat(matchingExpression.matches()).isTrue();

        nonMatchingExpression = new GalacticNumbersQuestion("how much is glob is some word ?");
        assertThat(matchingExpression.matches()).isTrue();
    }

    @Test
    public void shouldCreateANonMatchingExpression() throws ExpressionException {
        assertThat(nonMatchingExpression.matches()).isFalse();

    }

    @Test
    public void shouldResolveAMatchingExpression() throws Exception {
        when(mocked_calculator.calcArabicValue(anyList())).thenReturn(42);

        String response = matchingExpression.resolve(mocked_calculator);

        assertThat(response).isNotEmpty();
        verify(mocked_calculator).calcArabicValue(anyList());
        assertThat(response).isEqualTo("pish tegj glob glob is 42");
    }


    @Test
    public void shouldNotResolveAnExpressionIfGalacticNumbersAreNotDefined()
            throws Exception {
        when(mocked_calculator.calcArabicValue(anyList())).thenThrow(new RomanNumberException());

        assertThatExceptionOfType(ExpressionException.class)
                .isThrownBy(() ->  matchingExpression.resolve(mocked_calculator) );
        verify(mocked_calculator).calcArabicValue(anyList());
    }

}
