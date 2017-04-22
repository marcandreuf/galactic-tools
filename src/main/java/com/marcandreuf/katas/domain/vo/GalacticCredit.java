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

        public GalacticCreditBuilder(String symbol) {
            this.symbol = symbol;
        }

        public static GalacticCreditBuilder symbol(String symbol) {
            return new GalacticCreditBuilder(symbol);
        }

        public GalacticCredit arabicValue(double value) {
            return new GalacticCredit(symbol, value);
        }
    }
}
