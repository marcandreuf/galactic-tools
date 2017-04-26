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
import static org.mockito.Mockito.*;

/**
 * Created by marc on 22/04/17.
 */
public class GalacticCalculatorServiceUTest {

    //TODO: Rename umllet model memorise to register.
    //TODO: Rename umllet model retriveX to getX.
    //TODO: Rename CalculatorMemory to GalacticCalculatorService

    private Set mocked_setGalacticNumber;
    private Set mocked_setGalacticCredit;
    private GalacticNumber mocked_galacticNumber;
    private GalacticCredit mocked_galacticCredit;
    private GalacticCalculatorService galacticCalculatorService;
    private Set<GalacticNumber> stubbedSetGNumbers = new HashSet<>();
    private Set<GalacticCredit> stubbedSetGCredits = new HashSet<>();


    @Before
    public void setUp(){
        mocked_galacticNumber = mock(GalacticNumber.class);
        mocked_galacticCredit = mock(GalacticCredit.class);
        mocked_setGalacticNumber = mock(Set.class);
        mocked_setGalacticCredit = mock(Set.class);
        galacticCalculatorService = new GalacticCalculatorService(
                mocked_setGalacticNumber, mocked_setGalacticCredit);
    }


    @Test
    public void shouldRegisterAGalacticNumber(){
        galacticCalculatorService.register(mocked_galacticNumber);

        verify(mocked_setGalacticNumber).add(mocked_galacticNumber);
        verifyNoMoreInteractions(mocked_setGalacticNumber, mocked_setGalacticCredit);
    }

    @Test
    public void shouldRegisterAGalacticCredit(){
        galacticCalculatorService.register(mocked_galacticCredit);

        verify(mocked_setGalacticCredit).add(mocked_galacticCredit);
        verifyNoMoreInteractions(mocked_setGalacticNumber, mocked_setGalacticCredit);
    }

    @Test
    public void shouldGetTheGalacticNumberByItsSymbol() throws RomanNumberException {
        String sampleSymbol = "glob";
        GalacticNumber sampleGN = GalacticNumber.GalacticNumberBuilder.symbol(sampleSymbol).is("I").build();
        stubbedSetGNumbers.add(sampleGN);
        setUpStubbedService();

        GalacticNumber galacticNumber = galacticCalculatorService.getGalacticNumber(sampleSymbol);

        assertThat(galacticNumber).isSameAs(sampleGN);
    }

    private void setUpStubbedService() {
        galacticCalculatorService = new GalacticCalculatorService(stubbedSetGNumbers, stubbedSetGCredits);
    }


    @Test
    public void shouldGetTheGalacticCreditByItsName(){
        String sampleName = "Silver";
        GalacticCredit sampleGC = GalacticCreditBuilder.name(sampleName).arabicValue(1).build();
        stubbedSetGCredits.add(sampleGC);
        setUpStubbedService();

        GalacticCredit galacticCredit = galacticCalculatorService.getGalacticCredit(sampleName);

        assertThat(galacticCredit).isSameAs(sampleGC);
    }


    @Test
    public void shouldAddUpTheListOfGalacticNumberSymbolsIntoAnArabicValue() throws RomanNumberException {
        GalacticNumber gnGlob = GalacticNumber.GalacticNumberBuilder.symbol("glob").is("I").build();
        GalacticNumber gnPish = GalacticNumber.GalacticNumberBuilder.symbol("pish").is("III").build();
        stubbedSetGNumbers.add(gnGlob);
        stubbedSetGNumbers.add(gnPish);
        setUpStubbedService();

        int value = galacticCalculatorService.addGalacticNumbers("glob", "glob");
        assertThat(value).isEqualTo(2);

        value = galacticCalculatorService.addGalacticNumbers("glob", "glob", "pish");
        assertThat(value).isEqualTo(5);

    }




}
