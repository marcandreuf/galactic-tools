package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;
import com.marcandreuf.katas.domain.vo.GalacticCredit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by marc on 28/04/17.
 */
public class GalacticCreditsQuestion extends BaseExpression {

    private static final String CREDIT_QUESTION_PATTERN = "\\s*how\\s+many\\s+Credits\\s+is\\s+([a-z\\s]+)([A-Z][a-z\\s]+)\\?\\s*$";
    private static final int CQ_UNITS_GROUP = 1;
    private static final int CQ_CREDITNAME_GROUP = 2;


    private final String creditName;
    private final String galacticNumbers;
    private final List<String> lstGalNums;
    private final boolean isMatch;


    public GalacticCreditsQuestion(String question) {
        Matcher creditsQuestionMatcher = getMatcher(question, CREDIT_QUESTION_PATTERN);
        if(creditsQuestionMatcher.matches()){
            this.creditName = creditsQuestionMatcher.group(CQ_CREDITNAME_GROUP).trim();
            this.galacticNumbers = creditsQuestionMatcher.group(CQ_UNITS_GROUP).trim();
            this.lstGalNums = getUnitsList(galacticNumbers);
            this.isMatch = true;
        }else {
            this.creditName = "";
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
            GalacticCredit galacticCredit = calculatorService.getGalacticCredit(creditName);
            int responseValue = (int) (galacticNumbersArabicValue * galacticCredit.getValue());
            return galacticNumbers + " " + creditName + " is " + responseValue + " Credits";
        } catch (RomanNumberException e) {
            throw new ExpressionException(e.getMessage(), e);
        }
    }
}
