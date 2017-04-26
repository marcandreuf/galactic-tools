package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;
import com.marcandreuf.katas.domain.vo.GalacticNumber;

import java.util.regex.Matcher;

/**
 * Created by andreufm on 07/04/2017.
 *
 * This class is responsible to handle a valid galactic number definition expression.
 *
 * Example expression "glob is I"
 *
 */
public class GalacticNumberExpression extends BaseExpression {
    private static final String UNIT_STATEMENT_PATTERN = "^([a-z]+)\\s+is\\s+([A-Z]+)\\s*$";
    private static final int US_UNIT_GROUP = 1;
    private static final int US_ROMANNUMBER_GROUP = 2;

    private final String symbol;
    private final String romanNum;
    private final boolean isMatch;

    public GalacticNumberExpression(String sentence) throws ExpressionException {
        Matcher unitStatementMatcher = getMatcher(sentence, UNIT_STATEMENT_PATTERN);
        if(unitStatementMatcher.matches()){
            this.symbol = unitStatementMatcher.group(US_UNIT_GROUP);
            this.romanNum = unitStatementMatcher.group(US_ROMANNUMBER_GROUP);
            this.isMatch = true;
        }else{
            this.symbol = "";
            this.romanNum = "";
            this.isMatch = false;
        }
    }

    @Override
    public boolean matches() {
        return isMatch;
    }

    @Override
    public String resolve(GalacticCalculatorService cache) throws ExpressionException {
        GalacticNumber galacticNumber = tryCreateGalacticNumber(symbol, romanNum);
        cache.register(galacticNumber);
        return "";
    }

    private GalacticNumber tryCreateGalacticNumber(String symbol, String romanNum) throws ExpressionException {
        try {
            return GalacticNumber.GalacticNumberBuilder.symbol(symbol).is(romanNum).build();
        } catch (RomanNumberException e) {
            throw new ExpressionException(e.getMessage(), e);
        }
    }
}
