package com.marcandreuf.katas.domain;


import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.marcandreuf.katas.domain.RomanNumber.ERR_MSG_IS_NOT_A_VALID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by andreufm on 31/03/2017.
 */
public class RomanNumberUTest {

    @Test
    public void testCreateRomanNumberOne() throws RomanNumberException {
        assertRomanNumber("I", 1);
    }

    private void assertRomanNumber(String symbol, int value) throws RomanNumberException {
        RomanNumber rmOne = RomanNumber.parse(symbol);
        assertThat(rmOne.toArabicValue()).isEqualTo(value);
    }

    @Test
    public void testCreateRomanNumberTwo() throws RomanNumberException {
        assertRomanNumber("II", 2);
    }

    @Test
    public void testCreateRomanNumberUnits() throws RomanNumberException {
        assertRomanNumber("III", 3);
        assertRomanNumber("IV", 4);
        assertRomanNumber("VII", 7);
        assertRomanNumber("IX", 9);
    }

    @Test
    public void testCreateRomanNumberTens() throws RomanNumberException {
        assertRomanNumber("X", 10);
        assertRomanNumber("XL", 40);
        assertRomanNumber("L", 50);
        assertRomanNumber("XC", 90);
    }

    @Test
    public void testCreateRomanNumberHundreds() throws RomanNumberException {
        assertRomanNumber("C", 100);
        assertRomanNumber("CD", 400);
        assertRomanNumber("D", 500);
        assertRomanNumber("CM", 900);
    }

    @Test
    public void testCreateRomanNumberThousands() throws RomanNumberException {
        assertRomanNumber("M", 1000);
        assertRomanNumber("MMMCMXCIX", 3999);
    }

    @Test
    public void testCreateRomanNumberSampleRandoms() throws RomanNumberException {
        assertRomanNumber("MLI", 1051);
        assertRomanNumber("MCMIII", 1903);
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
    public void testGetSymbol() throws RomanNumberException {
        RomanNumber romanNumber = RomanNumber.parse("M");
        assertThat(romanNumber.getSymbol()).isEqualTo("M");
    }

}
