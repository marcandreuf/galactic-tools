package com.marcandreuf.katas.domain.vo;

import org.junit.Test;

import static com.marcandreuf.katas.domain.vo.GalacticCredit.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by marc on 21/04/17.
 */
public class GalacticCreditUTest {

    //TODO: GalacticCredit does not need list of galacticNumbers.

    @Test
    public void shouldCreateAGalacticCredit(){
        GalacticCredit galacticCredit =
                GalacticCreditBuilder
                        .symbol("Silver")
                        .arabicValue(100.1)
                        .build();

        assertThat(galacticCredit.getSymbol()).isEqualTo("Silver");
        assertThat(galacticCredit.getValue()).isEqualTo(100.1);
    }
}
