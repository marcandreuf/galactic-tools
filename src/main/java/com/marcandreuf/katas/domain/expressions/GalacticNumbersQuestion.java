package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by marc on 28/04/17.
 *
 * This class is responsible to handle a valid galactic number question expression.
 *
 * Example expression "how much is pish tegj glob glob ?"
 */
public class GalacticNumbersQuestion extends BaseExpression {

    private static final String UNITS_QUESTION_PATTERN = "^\\s*how\\s+much\\s+is\\s+([a-z\\s]+)\\s+\\?\\s*$";
    private static final int UQ_UNITS_GROUP = 1;

    private final String galacticNumbers;
    private final List<String> lstGalNums;
    private final boolean isMatch;

    public GalacticNumbersQuestion(String question) {
        Matcher unitsQuestionMatcher = getMatcher(question, UNITS_QUESTION_PATTERN);
        if(unitsQuestionMatcher.matches()){
            String galNums = unitsQuestionMatcher.group(UQ_UNITS_GROUP).trim();
            this.galacticNumbers = galNums;
            this.lstGalNums = getUnitsList(galNums);
            this.isMatch = true;
        }else{
            this.galacticNumbers = "";
            this.lstGalNums = new ArrayList<>();
            this.isMatch = false;
        }
    }

    @Override
    public boolean matches() {
        return isMatch;
    }

    @Override
    public String resolve(GalacticCalculatorService calculatorService) throws ExpressionException {
        try {
            int galacticNumbersArabicValue = calculatorService.calcArabicValue(lstGalNums);
            return galacticNumbers + " is " +galacticNumbersArabicValue;
        } catch (RomanNumberException e) {
            throw new ExpressionException(e.getMessage(), e);
        }

    }
}
