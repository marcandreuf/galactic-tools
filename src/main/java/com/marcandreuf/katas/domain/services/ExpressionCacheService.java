package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.vo.GalacticCredit;
import com.marcandreuf.katas.domain.vo.GalacticNumber;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by marc on 22/04/17.
 */
public class ExpressionCacheService {
    private final Set<GalacticNumber> galacticNumbers;
    private final Set<GalacticCredit> galacticCredits;

    public ExpressionCacheService(Set<GalacticNumber> galacticNumbers, Set<GalacticCredit> galacticCredits) {
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
        return galacticCredits.stream().filter(gc -> gc.getSymbol().equals(symbol)).findFirst().get();
    }
}