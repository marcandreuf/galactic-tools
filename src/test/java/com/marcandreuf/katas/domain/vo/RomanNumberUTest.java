package com.marcandreuf.katas.domain.vo;


import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.marcandreuf.katas.domain.vo.RomanNumber.ERR_MSG_IS_NOT_A_VALID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by andreufm on 31/03/2017.
 */
public class RomanNumberUTest {

    @Test
    public void shouldCreateRomanNumberOne() throws RomanNumberException {
        assertParsedValueOfRomanNumber("I", 1);
    }

    private void assertParsedValueOfRomanNumber(String symbol, int value) throws RomanNumberException {
        RomanNumber rmOne = RomanNumber.parse(symbol);
        assertThat(rmOne.toArabicValue()).isEqualTo(value);
    }

    @Test
    public void shouldCreateRomanNumberTwo() throws RomanNumberException {
        assertParsedValueOfRomanNumber("II", 2);
    }

    @Test
    public void shouldCreateRomanNumberUnits() throws RomanNumberException {
        assertParsedValueOfRomanNumber("III", 3);
        assertParsedValueOfRomanNumber("IV", 4);
        assertParsedValueOfRomanNumber("VII", 7);
        assertParsedValueOfRomanNumber("IX", 9);
    }

    @Test
    public void shouldCreateRomanNumberTens() throws RomanNumberException {
        assertParsedValueOfRomanNumber("X", 10);
        assertParsedValueOfRomanNumber("XL", 40);
        assertParsedValueOfRomanNumber("L", 50);
        assertParsedValueOfRomanNumber("XC", 90);
    }

    @Test
    public void shouldCreateRomanNumberHundreds() throws RomanNumberException {
        assertParsedValueOfRomanNumber("C", 100);
        assertParsedValueOfRomanNumber("CD", 400);
        assertParsedValueOfRomanNumber("D", 500);
        assertParsedValueOfRomanNumber("CM", 900);
    }

    @Test
    public void shouldCreateRomanNumberThousands() throws RomanNumberException {
        assertParsedValueOfRomanNumber("M", 1000);
        assertParsedValueOfRomanNumber("MMMCMXCIX", 3999);
    }

    @Test
    public void shouldCreateRomanNumberSampleRandoms() throws RomanNumberException {
        assertParsedValueOfRomanNumber("MLI", 1051);
        assertParsedValueOfRomanNumber("MCMIII", 1903);
    }

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowAnExceptionIfNumberIsNotValid() throws RomanNumberException {
        expectedException.expect(RomanNumberException.class);
        expectedException.expectMessage("IMNS"+ERR_MSG_IS_NOT_A_VALID);

        RomanNumber.parse("IMNS");
    }

    @Test
    public void shouldGetSymbol() throws RomanNumberException {
        RomanNumber romanNumber = RomanNumber.parse("M");
        assertThat(romanNumber.getSymbol()).isEqualTo("M");
    }

}
