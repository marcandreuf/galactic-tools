package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.vo.GalacticCredit;
import com.marcandreuf.katas.domain.vo.GalacticNumber;
import com.marcandreuf.katas.domain.vo.RomanNumber;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public GalacticCredit getGalacticCredit(String name) {
        return galacticCredits.stream().filter(gc -> gc.getName().equals(name)).findFirst().get();
    }

    public int calcArabicValue(List<String> galacticNumberSymbols) throws RomanNumberException {
        String romanNum =  galacticNumberSymbols
                .stream()
                .map(s -> getGalacticNumber(s).getRomanNumber().getSymbol())
                .collect(Collectors.joining());
        return RomanNumber.parse(romanNum).toArabicValue();
    }


}
