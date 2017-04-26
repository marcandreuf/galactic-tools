package com.marcandreuf.katas.domain.expressions;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by marc on 26/04/17.
 *
 * This class encapsulates common methods for the Expression subtypes.
 *
 */
public abstract class BaseExpression implements IExpression {

    //TODO: Add this abstract class into the model design


    protected Matcher getMatcher(String line, String pattern){
        return Pattern.compile(pattern).matcher(line);
    }

    protected List<String> getUnitsList(String units){
        List<String> lstUnits = Arrays.asList(units.split(" "));
        return lstUnits.stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

}
