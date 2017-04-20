package com.marcandreuf.katas.domain.vo;

import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.vo.GalacticNumber;
import com.marcandreuf.katas.domain.vo.RomanNumber;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.marcandreuf.katas.domain.vo.GalacticNumber.*;
import static com.marcandreuf.katas.domain.vo.RomanNumber.ERR_MSG_IS_NOT_A_VALID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by andreufm on 31/03/2017.
 */
public class GalacticNumberUTest {

    @Test
    public void shouldCreateGalacticNumber() throws RomanNumberException {
        GalacticNumber galacticNumber = GalacticNumberBuilder.symbol("glob").is("I");

        assertThat(galacticNumber.getSymbol()).isEqualTo("glob");
        RomanNumber romanNumber = galacticNumber.getRomanNumber();
        assertThat(romanNumber.getSymbol()).isEqualTo("I");
        assertThat(romanNumber.toArabicValue()).isEqualTo(1);
    }

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowAGalacticNumberException() throws RomanNumberException {
        expectedException.expect(RomanNumberException.class);
        expectedException.expectMessage("NARN"+ERR_MSG_IS_NOT_A_VALID);

        GalacticNumberBuilder.symbol("NotARomanNumber").is("NARN");
    }
}
