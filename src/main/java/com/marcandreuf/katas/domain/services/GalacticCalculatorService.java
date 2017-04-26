package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.vo.GalacticCredit;
import com.marcandreuf.katas.domain.vo.GalacticNumber;

import javax.naming.BinaryRefAddr;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by marc on 22/04/17.
 */

//TODO: Rename "CalculatorMemory" to "GalacticCalculatorService" int he model as it will have calculations operations.

public class GalacticCalculatorService {
    private final Set<GalacticNumber> galacticNumbers;
    private final Set<GalacticCredit> galacticCredits;

    public GalacticCalculatorService(Set<GalacticNumber> galacticNumbers, Set<GalacticCredit> galacticCredits) {
        this.galacticNumbers = galacticNumbers;
        this.galacticCredits = galacticCredits;
    }

    public void register(GalacticNumber galacticNumber) {
        galacticNumbers.add(galacticNumber);
    }

    public void register(GalacticCredit galacticCredit) {
        galacticCredits.add(galacticCredit);
    }

    public GalacticNumber getGalacticNumber(String symbol) {
        return galacticNumbers.stream().filter(gn -> gn.getSymbol().equals(symbol)).findFirst().get();
    }

    public GalacticCredit getGalacticCredit(String symbol) {
        return galacticCredits.stream().filter(gc -> gc.getName().equals(symbol)).findFirst().get();
    }

    public int addGalacticNumbers(String... galacticNumberSymbols) {
        List<String> numbers = Arrays.asList(galacticNumberSymbols);

        //TODO: create roman number symbol

        //TODO: create roman number

        //TODO: return the arabic value of the roman number.

    }
}
