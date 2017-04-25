package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.services.ExpressionCacheService;
import com.marcandreuf.katas.domain.vo.GalacticNumber;

/**
 * Created by andreufm on 07/04/2017.
 *
 * This class is the specific expression for registering galactic numbers into the system.
 *
 * Example expression "pish tegj glob glob is 42"
 *
 */
public class GalacticNumberExpression implements IExpression {
    private final GalacticNumber galacticNumber;

    private GalacticNumberExpression(GalacticNumber galacticNumber){
        this.galacticNumber = galacticNumber;
    }

    public static IExpression matches(String sentence) throws RomanNumberException {
        //TODO: pattern matching with group reading to build the galactic number to be processed.
        return new GalacticNumberExpression(GalacticNumber.GalacticNumberBuilder.symbol("a").is("I").build());
    }

    @Override
    public String resolve(ExpressionCacheService cache) {
        cache.register(galacticNumber);
        return "";
    }
}
