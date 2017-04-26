package com.marcandreuf.katas.domain.expressions;

import com.marcandreuf.katas.domain.services.GalacticCalculatorService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

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
    private final int statementValue;
    private final List<String> lstUnits;
    private final boolean isMatch;


    public GalacticCreditExpression(String sentence) {
        Matcher creditStatementMatcher = getMatcher(sentence, CREDIT_STATEMENT_PATTERN);
        if(creditStatementMatcher.matches()){
            this.creditName = creditStatementMatcher.group(CS_CREDITNAME_GROUP).trim();
            this.statementValue = Integer.parseInt(creditStatementMatcher.group(CS_CREDITVALUE_GROUP));
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
    public String resolve(GalacticCalculatorService cache) {

        //TODO: 1. Add up galactic numbers arabic values.

        //TODO: 2. Calculate galactic credit value.
        // double galacticCreditValue = statementValue / galacticNumbersArabicValue;

        //TODO: 3. Create a GalacticCredit

        //TODO: 4. Register the galactic credit into the CalculatorService. (cache)

        return null;
    }
}
