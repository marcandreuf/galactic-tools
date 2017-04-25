package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.services.ExpressionCacheService;
import com.marcandreuf.katas.domain.vo.GalacticNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andreufm on 07/04/2017.
 *
 * This class is responsible to handle a valid galactic number definition expression.
 *
 * Example expression "pish tegj glob glob is 42"
 *
 */
public class GalacticNumberExpression implements IExpression {

    private final String sentence;
    private final boolean isMatch;
    private final GalacticNumber galacticNumber;

    private static final String UNIT_STATEMENT_PATTERN = "^([a-z]+)\\s+is\\s+([A-Z]+)\\s*$";
    private static final int US_UNIT_GROUP = 1;
    private static final int US_ROMANNUMBER_GROUP = 2;

    public GalacticNumberExpression(String sentence) throws ExpressionException {
        this.sentence = sentence;
        Matcher unitStatementMatcher = getMatcher(sentence, UNIT_STATEMENT_PATTERN);
        if(unitStatementMatcher.matches()){
            String symbol = unitStatementMatcher.group(US_UNIT_GROUP);
            String romanNum = unitStatementMatcher.group(US_ROMANNUMBER_GROUP);
            this.galacticNumber = tryCreateGalacticNumber(symbol, romanNum);
            if(this.galacticNumber == null){
                this.isMatch = false;
            }else{
                this.isMatch = true;
            }
        }else{
            this.isMatch = false;
            this.galacticNumber = null;
        }
    }

    private GalacticNumber tryCreateGalacticNumber(String symbol, String romanNum){
        try {
            return GalacticNumber.GalacticNumberBuilder.symbol(symbol).is(romanNum).build();
        } catch (RomanNumberException e) {
            return null;
        }
    }

    private Matcher getMatcher(String line, String pattern){
        return Pattern.compile(pattern).matcher(line);
    }

    @Override
    public boolean matches() {
        return isMatch;
    }

    @Override
    public String resolve(ExpressionCacheService cache) {
        cache.register(galacticNumber);
        return "";
    }
}
