package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.exceptions.ExpressionException;
import com.marcandreuf.katas.domain.exceptions.RomanNumberException;
import com.marcandreuf.katas.domain.services.GalacticCalculatorService;
import com.marcandreuf.katas.domain.vo.GalacticCredit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static com.marcandreuf.katas.domain.vo.GalacticCredit.GalacticCreditBuilder;

/**
 * Created by marc on 26/04/17.
 *
 * This class is responsible to handle a valid galactic credit definition expression.
 *
 * Example expression "glob glob Silver is 34 Credits"
 */
public class GalacticCreditExpression extends BaseExpression {

    private static final String CREDIT_STATEMENT_PATTERN = "^\\s*([a-z\\s]+)([A-Z][a-z\\s]+)is\\s+([0-9]+)\\s+Credits\\s*$";
    private static final int CS_UNITS_GROUP = 1;
    private static final int CS_CREDITNAME_GROUP = 2;
    private static final int CS_CREDITVALUE_GROUP = 3;

    private final String creditName;
    private final double statementValue;
    private final List<String> lstUnits;
    private final boolean isMatch;


    public GalacticCreditExpression(String sentence) {
        Matcher creditStatementMatcher = getMatcher(sentence, CREDIT_STATEMENT_PATTERN);
        if(creditStatementMatcher.matches()){
            this.creditName = creditStatementMatcher.group(CS_CREDITNAME_GROUP).trim();
            this.statementValue = Double.parseDouble(creditStatementMatcher.group(CS_CREDITVALUE_GROUP));
            this.lstUnits = getUnitsList(creditStatementMatcher.group(CS_UNITS_GROUP));
            this.isMatch = true;
        }else{
            this.creditName = "";
            this.statementValue = 0;
            this.lstUnits = new ArrayList<>();
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
            int galacticNumbersArabicValue = calculatorService.calcArabicValue(lstUnits);
            double galacticCreditValue = statementValue / galacticNumbersArabicValue;
            GalacticCredit galacticCredit = GalacticCreditBuilder
                    .name(this.creditName).arabicValue(galacticCreditValue).build();
            calculatorService.register(galacticCredit);
            return "";
        } catch (RomanNumberException e) {
            throw new ExpressionException(e.getMessage(), e);
        }
    }
}
