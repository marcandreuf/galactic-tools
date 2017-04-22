package com.marcandreuf.katas.domain.services;

import com.marcandreuf.katas.domain.vo.GalacticNumber;
import org.junit.Test;

/**
 * Created by marc on 22/04/17.
 */
public class CalculatorMemoryUTest {

    //TODO: Rename umllet model memorise to register.
    //TODO: Rename CalculatorMemory to ExpressionCache

    private GalacticNumber mocked_galacticNumber;
    private ExpressionCache expressionCache;


    @Test
    public void shouldRegisterAGalacticNumber(){



        expressionCache.register(mocked_galacticNumber);


        //TODO: verify the gn is registered in the set.

    }


}
