package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.vo.GalacticCredit;
import com.marcandreuf.katas.domain.vo.GalacticNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.marcandreuf.katas.domain.vo.GalacticCredit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by marc on 22/04/17.
 */
public class CalculatorMemoryUTest {

    //TODO: Rename umllet model memorise to register.
    //TODO: Rename umllet model retriveX to getX.
    //TODO: Rename CalculatorMemory to ExpressionCacheService

    private Set mocked_setGalacticNumber;
    private Set mocked_setGalacticCredit;
    private GalacticNumber mocked_galacticNumber;
    private GalacticCredit mocked_galacticCredit;
    private ExpressionCacheService expressionCache;
    private Set<GalacticNumber> stubbedSetGNumbers = new HashSet<>();
    private Set<GalacticCredit> stubbedSetGCredits = new HashSet<>();


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
        String sampleSymbol = "glob";
        GalacticNumber sampleGN = GalacticNumber.GalacticNumberBuilder.symbol(sampleSymbol).is("I").build();
        stubbedSetGNumbers.add(sampleGN);
        setUpStubbedService();

        GalacticNumber galacticNumber = expressionCache.getGalacticNumber(sampleSymbol);

        assertThat(galacticNumber).isSameAs(sampleGN);
    }

    private void setUpStubbedService() {
        expressionCache = new ExpressionCacheService(stubbedSetGNumbers, stubbedSetGCredits);
    }


    @Test
    public void shouldGetTheGalacticCreditByItsName(){
        String sampleName = "Silver";
        GalacticCredit sampleGC = GalacticCreditBuilder.name(sampleName).arabicValue(1).build();
        stubbedSetGCredits.add(sampleGC);
        setUpStubbedService();

        GalacticCredit galacticCredit = expressionCache.getGalacticCredit(sampleName);

        assertThat(galacticCredit).isSameAs(sampleGC);
    }




}
