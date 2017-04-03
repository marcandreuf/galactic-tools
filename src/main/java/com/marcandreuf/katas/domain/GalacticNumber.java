package com.marcandreuf.katas.domain;

import com.marcandreuf.katas.domain.exceptions.RomanNumberException;

/**
 * Created by andreufm on 03/04/2017.
 */
public class GalacticNumber {

    private String symbol;
    private final RomanNumber romanNumber;

    public GalacticNumber(String symbol, RomanNumber romanNumber) {
        this.symbol = symbol;
        this.romanNumber = romanNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public RomanNumber getRomanNumber() {
        return romanNumber;
    }

    public static class GalacticNumberBuilder{

        private String unit;

        private GalacticNumberBuilder(String unit){
            this.unit = unit;
        }

        public static GalacticNumberBuilder symbol(String galacticUnit) {
            return new GalacticNumberBuilder(galacticUnit);
        }

        public GalacticNumber is(String romanNumber) throws RomanNumberException {
            RomanNumber romNum = RomanNumber.parse(romanNumber);
            return new GalacticNumber(unit, romNum);
        }
    }

}
