package com.marcandreuf.katas.domain.vo;

/**
 * Created by marc on 21/04/17.
 */
public class GalacticCredit {
    private final String name;
    private final double value;

    public GalacticCredit(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public static class GalacticCreditBuilder{
        private final String name;
        private double value;

        public GalacticCreditBuilder(String name) {
            this.name = name;
        }

        public static GalacticCreditBuilder name(String symbol) {
            return new GalacticCreditBuilder(symbol);
        }

        public GalacticCreditBuilder arabicValue(double value) {
            this.value = value;
            return this;
        }

        public GalacticCredit build(){
            return new GalacticCredit(name, value);
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        GalacticCredit that = (GalacticCredit) o;

        return this.name.equals(that.name) && this.value == that.value;
    }
}
