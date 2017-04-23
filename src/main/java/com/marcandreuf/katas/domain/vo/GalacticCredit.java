package com.marcandreuf.katas.domain.vo;

/**
 * Created by marc on 21/04/17.
 */
public class GalacticCredit {
    private final String symbol;
    private final double value;

    public GalacticCredit(String symbol, double value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getValue() {
        return value;
    }

    public static class GalacticCreditBuilder{
        private final String symbol;
        private double value;

        public GalacticCreditBuilder(String symbol) {
            this.symbol = symbol;
        }

        public static GalacticCreditBuilder symbol(String symbol) {
            return new GalacticCreditBuilder(symbol);
        }

        public GalacticCreditBuilder arabicValue(double value) {
            this.value = value;
            return this;
        }

        public GalacticCredit build(){
            return new GalacticCredit(symbol, value);
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

        GalacticCredit that = (GalacticCredit) o;

        return this.symbol.equals(that.symbol) && this.value == that.value;
    }
}
