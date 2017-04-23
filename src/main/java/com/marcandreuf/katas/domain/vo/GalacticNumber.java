package com.marcandreuf.katas.domain.vo;

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
        private RomanNumber romanNumber;

        private GalacticNumberBuilder(String unit){
            this.unit = unit;
        }

        public static GalacticNumberBuilder symbol(String galacticUnit) {
            return new GalacticNumberBuilder(galacticUnit);
        }

        public GalacticNumberBuilder is(String symbol) throws RomanNumberException {
            romanNumber = RomanNumber.parse(symbol);
            return this;
        }

        public GalacticNumber build(){
            return new GalacticNumber(unit, romanNumber);
        }
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        GalacticNumber that = (GalacticNumber) o;
        return this.symbol.equals(that.symbol) && this.romanNumber.equals(that.romanNumber);
    }
}
