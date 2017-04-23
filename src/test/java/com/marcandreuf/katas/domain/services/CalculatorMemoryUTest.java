package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.vo.GalacticCredit;
import com.marcandreuf.katas.domain.vo.GalacticNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by marc on 22/04/17.
 */
public class CalculatorMemoryUTest {

    //TODO: Rename umllet model memorise to register.
    //TODO: Rename CalculatorMemory to ExpressionCacheService

    private Set mocked_setGalacticNumber;
    private Set mocked_setGalacticCredit;
    private GalacticNumber mocked_galacticNumber;
    private GalacticCredit mocked_galacticCredit;
    private ExpressionCacheService expressionCache;

    @Before
    public void setUp(){
        mocked_galacticNumber = mock(GalacticNumber.class);
        mocked_galacticCredit = mock(GalacticCredit.class);
        mocked_setGalacticNumber = mock(Set.class);
        mocked_setGalacticCredit = mock(Set.class);
        expressionCache = new ExpressionCacheService(mocked_setGalacticNumber, mocked_setGalacticCredit);
    }


    @Test
    public void shouldRegisterAGalacticNumber(){
        expressionCache.register(mocked_galacticNumber);

        verify(mocked_setGalacticNumber).add(mocked_galacticNumber);
        verifyNoMoreInteractions(mocked_setGalacticNumber, mocked_setGalacticCredit);
    }

    @Test
    public void shouldRegisterAGalacticCredit(){
        expressionCache.register(mocked_galacticCredit);

        verify(mocked_setGalacticCredit).add(mocked_galacticCredit);
        verifyNoMoreInteractions(mocked_setGalacticNumber, mocked_setGalacticCredit);
    }

    @Test
    public void shouldGetTheGalacticNumberByItsSymbol() throws RomanNumberException {
        Set<GalacticNumber> stubbedSetGNumbers = new HashSet<>();
        Set<GalacticCredit> stubbedSetGCredits = new HashSet<>();
        GalacticNumber sampleGN = GalacticNumber.GalacticNumberBuilder.symbol("glob").is("I").build();
        stubbedSetGNumbers.add(sampleGN);

        expressionCache = new ExpressionCacheService(stubbedSetGNumbers, stubbedSetGCredits);

        GalacticNumber galacticNumber = expressionCache.getGalacticNumber("glob");

        assertThat(galacticNumber).isSameAs(sampleGN);

    }


}
