package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;
import com.marcandreuf.katas.domain.vo.GalacticCredit;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by marc on 28/04/17.
 */
public class GalacticCreditsQuestionUTest {

    private IExpression matchingExpression;
    private IExpression nonMatchingExpression;
    private GalacticCalculatorService mocked_calculator;

    @Before
    public void setUp(){
        matchingExpression = new GalacticCreditsQuestion("how many Credits is glob prok Silver ?");
        nonMatchingExpression = new GalacticCreditsQuestion("not matching question here ");
        mocked_calculator = mock(GalacticCalculatorService.class);
    }

    @Test
    public void shouldCreateAMatchingExpression() throws ExpressionException {
        assertThat(matchingExpression.matches()).isTrue();

        nonMatchingExpression = new GalacticCreditsQuestion("how many Credits is glob is some word ?");
        assertThat(matchingExpression.matches()).isTrue();
    }

    @Test
    public void shouldCreateANonMatchingExpression() throws ExpressionException {
        assertThat(nonMatchingExpression.matches()).isFalse();
    }

    @Test
    public void shouldResolveAMatchingExpression() throws Exception {
        when(mocked_calculator.calcArabicValue(anyList())).thenReturn(5);
        GalacticCredit stubbedGC = GalacticCredit.GalacticCreditBuilder.name("Silver").arabicValue(3).build();
        when(mocked_calculator.getGalacticCredit("Silver")).thenReturn(stubbedGC);

        String response = matchingExpression.resolve(mocked_calculator);

        assertThat(response).isNotEmpty();
        verify(mocked_calculator).calcArabicValue(anyList());
        assertThat(response).isEqualTo("glob prok Silver is 15 Credits");
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
