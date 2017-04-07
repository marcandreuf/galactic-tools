package com.marcandreuf.katas.services;

import com.marcandreuf.katas.domain.GalacticNumberStatement;
import com.marcandreuf.katas.domain.ReaderService;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by andreufm on 07/04/2017.
 */
public class IReaderServiceUTest {

    private ReaderService readerService;

    @Before
    public void setUp(){
        readerService = new ReaderService();

    }

    @Test
    public void testIExpressionRegistry(){

        readerService.addExpressionType(GalacticNumberStatement.class);


    }
}
