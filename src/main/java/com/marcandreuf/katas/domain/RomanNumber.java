package com.marcandreuf.katas.domain;



import com.marcandreuf.katas.domain.exceptions.RomanNumberException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andreufm on 31/03/2017.
 */
public class RomanNumber {
    public static final String ERR_MSG_IS_NOT_A_VALID = "Is not a valid roman number.";
    private final String symbol;
    private static final Map<String, Integer> ROMAN_ARABIC = new HashMap<>();
    private static final Pattern romNumMatcherPattern = Pattern.compile("M|CM|D|CD|C|XC|L|XL|X|IX|V|IV|I");

    static{
        ROMAN_ARABIC.put("I", 1);
        ROMAN_ARABIC.put("IV", 4);
        ROMAN_ARABIC.put("V", 5);
        ROMAN_ARABIC.put("IX", 9);
        ROMAN_ARABIC.put("X", 10);
        ROMAN_ARABIC.put("XL", 40);
        ROMAN_ARABIC.put("L", 50);
        ROMAN_ARABIC.put("XC", 90);
        ROMAN_ARABIC.put("C", 100);
        ROMAN_ARABIC.put("CD", 400);
        ROMAN_ARABIC.put("D", 500);
        ROMAN_ARABIC.put("CM", 900);
        ROMAN_ARABIC.put("M", 1000);
    }

    private RomanNumber(String symbol) {
        this.symbol = symbol;
    }

    public static RomanNumber parse(String symbol) throws RomanNumberException {
        if(isValid(symbol)) {
            return new RomanNumber(symbol);
        }else{
            throw new RomanNumberException(symbol + ERR_MSG_IS_NOT_A_VALID);
        }
    }

    protected static boolean isValid(String romanSymbol){
        String romanNumPatter = "^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return romanSymbol!= null && !romanSymbol.isEmpty()&& romanSymbol.matches(romanNumPatter);
    }

    public int toArabicValue() {
        return addUpArabicValues(symbol);
    }

    protected int addUpArabicValues(String romanNumber) {
        int arabicValue = 0;
        Matcher matcherSymbol = romNumMatcherPattern.matcher(romanNumber);
        while (matcherSymbol.find()) {
            arabicValue = accArabicValue(arabicValue, matcherSymbol.group(0));
        }
        return arabicValue;
    }

    private int accArabicValue(int arabicValue, String matchNum) {
        return ROMAN_ARABIC.entrySet().stream().filter(map -> map.getKey().equals(matchNum))
                .map(Map.Entry::getValue).reduce(arabicValue, Integer::sum);
    }

    public String getSymbol() {
        return symbol;
    }
}
